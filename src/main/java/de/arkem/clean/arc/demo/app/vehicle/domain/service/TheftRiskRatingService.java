package de.arkem.clean.arc.demo.app.vehicle.domain.service;

import de.arkem.clean.arc.demo.app.vehicle.adapter.out.db.VehicleCrudRepository;
import de.arkem.clean.arc.demo.app.vehicle.adapter.out.masterdata.VehicleDataDto;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.risk.rating.CountryCode;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.CountryOfManufacture;
import de.arkem.clean.arc.demo.app.vehicle.usecase.interactor.CreateVehicleInteractor;

import java.util.List;

public class TheftRiskRatingService {

    //private CreateVehicleInteractor interactor;
    //private VehicleDataDto vehicleDataDto;
    //private VehicleCrudRepository crudRepo;

    public int detectRiskScore(CountryOfManufacture countryOfManufacture, List<CountryCode> riskCountries, CountryCode registrationCountry) {
        int riskScore = 0;
        boolean crossingBorder = !countryOfManufacture.value().equals(registrationCountry.value());
        boolean riskCountry = riskCountries.contains(registrationCountry);

        if (crossingBorder) {
            riskScore += 20;
        }
        if (riskCountry) {
            riskScore += 10;
        }
        if (crossingBorder && riskCountry) {
            riskScore += 30;
        }
        return riskScore;
    }
}
