package de.arkem.clean.arc.demo.modulith.arch.unit.plugin;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;

@AnalyzeClasses(packages = "de.arkem",
        importOptions = {ImportOption.DoNotIncludeTests.class,
                ImportOption.DoNotIncludeJars.class})
public class CleanArchitectureTemplateTest {

    @ArchTest
    void clean_architecture_fitness_function(JavaClasses classes) {
        CleanArchitecture rule = CleanArchitecture.cleanArchitecture(CleanArchitectureCheck.ARCHITECTURAL_EXPRESSIVE)
                .domainModel("..domain.model..")
                .domainService("..domain.service..")
                .adapterIn("..adapter.in..")
                .adapterOut("..adapter.out..")
                .usecaseInteractor("..usecase.interactor..")
                .useCaseIn("..usecase.in..")
                .useCaseOut("..usecase.out..");

        rule.check(classes);
    }
}
