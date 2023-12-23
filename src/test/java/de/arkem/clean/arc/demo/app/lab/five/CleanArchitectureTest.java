package de.arkem.clean.arc.demo.app.lab.five;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import de.arkem.clean.arc.demo.app.lab.clean.arch.unit.plugin.CleanArchitecture;
import de.arkem.clean.arc.demo.app.lab.clean.arch.unit.plugin.CleanArchitectureCheck;

@AnalyzeClasses(packages = "de.arkem.clean.arc.demo.app.lab.five",
        importOptions = {ImportOption.DoNotIncludeTests.class,
                ImportOption.DoNotIncludeJars.class})
public class CleanArchitectureTest {

    @ArchTest
    void clean_architecture_fitness_function(JavaClasses javaClasses) {
        CleanArchitecture rule = CleanArchitecture.cleanArchitecture(CleanArchitectureCheck.ARCHITECTURAL_EXPRESSIVE)
                .domainModel("..domain.model..")
                .domainService("..domain.service..")
                .adapterIn("..adapter.in..")
                .adapterOut("..adapter.out..")
                .useCaseIn("..usecase.in..")
                .useCaseOut("..usecase.out..");
        rule.check(javaClasses);
    }
}