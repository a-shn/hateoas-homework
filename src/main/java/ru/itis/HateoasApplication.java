package ru.itis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itis.models.*;
import ru.itis.repositories.*;

import static java.util.Arrays.asList;

@SpringBootApplication
public class HateoasApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HateoasApplication.class, args);

        CollegesRepository collegesRepository = context.getBean(CollegesRepository.class);
        AcademicAdvisersRepository academicAdvisersRepository = context.getBean(AcademicAdvisersRepository.class);
        MastersRepository mastersRepository = context.getBean(MastersRepository.class);
        MasterApplicationsRepository masterApplicationsRepository = context.getBean(MasterApplicationsRepository.class);
        AcademicAdviserApplicationsRepository academicAdviserApplicationsRepository = context.getBean(AcademicAdviserApplicationsRepository.class);

        College college = College.builder().name("College").build();
        collegesRepository.save(college);

        AcademicAdviser academicAdviser1 = AcademicAdviser.builder().name("Niels").surname("Bohr").college(college).build();
        AcademicAdviser academicAdviser2 = AcademicAdviser.builder().name("Albert").surname("Einstein").college(college).build();
        AcademicAdviser academicAdviser3 = AcademicAdviser.builder().name("Eric").surname("Verlinde").college(college).build();
        academicAdvisersRepository.saveAll(asList(academicAdviser1, academicAdviser2, academicAdviser3));

        Master master1 = Master.builder().college(college).name("Werner").surname("Heisenberg").build();
        Master master2 = Master.builder().college(college).name("Paul").surname("Dirac").build();
        Master master3 = Master.builder().college(college).name("Wolfgang").surname("Pauli").build();
//        Master master4 = Master.builder().college(college).name("Hendrik").surname("Kramers").build();
//        Master master5 = Master.builder().college(college).name("Nathan").surname("Rosen").build();
//        Master master6 = Master.builder().college(college).name("Nath").surname("Bose").build();
//        Master master7 = Master.builder().college(college).name("John").surname("Neumann").build();
//        Master master8 = Master.builder().college(college).name("Lev").surname("Landau").build();
        mastersRepository.saveAll(asList(master1, master2, master3)); //, master4, master5, master6, master8, master7));

        MasterApplication masterApplication1 = MasterApplication.builder().master(master1)
                .advisers(asList(academicAdviser1, academicAdviser3, academicAdviser2)).build();
        masterApplicationsRepository.save(masterApplication1);

        MasterApplication masterApplication2 = MasterApplication.builder().master(master2)
                .advisers(asList(academicAdviser1, academicAdviser2, academicAdviser3)).build();
        masterApplicationsRepository.save(masterApplication2);

        MasterApplication masterApplication3 = MasterApplication.builder().master(master3)
                .advisers(asList(academicAdviser3, academicAdviser1, academicAdviser2)).build();
        masterApplicationsRepository.save(masterApplication3);

//        MasterApplication masterApplication4 = MasterApplication.builder().master(master4)
//                .advisers(asList(academicAdviser3, academicAdviser2, academicAdviser1)).build();
//        masterApplicationsRepository.save(masterApplication4);
//
//        MasterApplication masterApplication5 = MasterApplication.builder().master(master5)
//                .advisers(asList(academicAdviser2, academicAdviser3, academicAdviser1)).build();
//        masterApplicationsRepository.save(masterApplication5);
//
//        MasterApplication masterApplication6 = MasterApplication.builder().master(master6)
//                .advisers(asList(academicAdviser3, academicAdviser1, academicAdviser2)).build();
//        masterApplicationsRepository.save(masterApplication6);
//
//        MasterApplication masterApplication7 = MasterApplication.builder().master(master7)
//                .advisers(asList(academicAdviser2, academicAdviser3, academicAdviser1)).build();
//        masterApplicationsRepository.save(masterApplication7);
//
//        MasterApplication masterApplication8 = MasterApplication.builder().master(master8)
//                .advisers(asList(academicAdviser1, academicAdviser2, academicAdviser3)).build();
//        masterApplicationsRepository.save(masterApplication8);

        AcademicAdviserApplication app1 = AcademicAdviserApplication.builder().academicAdviser(academicAdviser1)
                .masters(asList(master1, master2, master3)).required(1).build();
        academicAdviserApplicationsRepository.save(app1);

        AcademicAdviserApplication app2 = AcademicAdviserApplication.builder().academicAdviser(academicAdviser2)
                .masters(asList(master1, master2, master3)).required(1).build();
        academicAdviserApplicationsRepository.save(app2);

        AcademicAdviserApplication app3 = AcademicAdviserApplication.builder().academicAdviser(academicAdviser3)
                .masters(asList(master2, master1, master3)).required(1).build();
        academicAdviserApplicationsRepository.save(app3);
    }

}
