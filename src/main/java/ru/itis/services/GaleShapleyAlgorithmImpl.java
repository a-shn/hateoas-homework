package ru.itis.services;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@NoArgsConstructor
@Service
public class GaleShapleyAlgorithmImpl implements GaleShapleyAlgorithm {
    public Map<Object, Object> match(Map<Object, List<Object>> men, Map<Object, List<Object>> women) {
        Map<Object, Object> womenPair = new HashMap<>();
        List<Object> freeMen = new LinkedList<>(men.keySet());
//        for (Object id : women.keySet()) {
//            womenPair.put(id, null);
//        }
        while (freeMen.size() > 0) {
            List<Object> tmpList = new LinkedList<>(freeMen);
            for (Object man : freeMen) {
                Object firstWoman = men.get(man).get(0);
                if (womenPair.get(firstWoman) == null) {
                    womenPair.put(firstWoman, man);
                    tmpList.remove(man);
                }
                try {
                    if (women.get(firstWoman).indexOf(man) - women.get(firstWoman).indexOf(womenPair.get(firstWoman)) < 0) {
                        men.get(womenPair.get(firstWoman)).remove(firstWoman);
                        tmpList.add(womenPair.get(firstWoman));
                        womenPair.put(firstWoman, man);
                        tmpList.remove(man);
                    }
                } catch (NullPointerException e) {
                    men.get(man).remove(firstWoman);
                }
            }
            freeMen = tmpList;
        }
        return womenPair;
    }
}
