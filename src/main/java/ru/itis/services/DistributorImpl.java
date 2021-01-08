package ru.itis.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.models.AcademicAdviser;
import ru.itis.models.AcademicAdviserApplication;
import ru.itis.models.Master;
import ru.itis.models.MasterApplication;
import ru.itis.repositories.AcademicAdviserApplicationsRepository;
import ru.itis.repositories.MasterApplicationsRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class DistributorImpl implements Distributor {
    private final GaleShapleyAlgorithm galeShapleyAlgorithm;
    private final MasterApplicationsRepository masterApplicationsRepository;
    private final AcademicAdviserApplicationsRepository academicAdviserApplicationsRepository;

    @Override
    public Map<AcademicAdviser, Master> advisersAndMastersDistribution() {
        List<MasterApplication> masterApplications = masterApplicationsRepository.findAll();
        List<AcademicAdviserApplication> academicAdviserApplications = academicAdviserApplicationsRepository.findAll();
        Map<Object, List<Object>> masters = new HashMap<>();
        Map<Object, List<Object>> advisers = new HashMap<>();
        for (MasterApplication masterApplication : masterApplications) {
            masters.put(masterApplication.getMaster(), new ArrayList<>(masterApplication.getAdvisers()));
        }
        Integer required = 0;
        Map<Integer, AcademicAdviser> tmpMap = new HashMap<>();
        for (AcademicAdviserApplication academicAdviserApplication : academicAdviserApplications) {
            required += academicAdviserApplication.getRequired();
        }
        for (AcademicAdviserApplication academicAdviserApplication : academicAdviserApplications) {
            for (int i = 0; i < academicAdviserApplication.getRequired(); i++) {
                advisers.put(required, new ArrayList<>(academicAdviserApplication.getMasters()));
                tmpMap.put(required, academicAdviserApplication.getAcademicAdviser());
                required--;
            }
        }
        Map<Object, Object> matches = galeShapleyAlgorithm.match(masters, advisers);
        Map<AcademicAdviser, Master> result = new HashMap<>();
        for (Map.Entry<Object, Object> entry : matches.entrySet()) {
            result.put((AcademicAdviser) entry.getKey(), (Master) entry.getValue());
        }
        return result;
    }
}
