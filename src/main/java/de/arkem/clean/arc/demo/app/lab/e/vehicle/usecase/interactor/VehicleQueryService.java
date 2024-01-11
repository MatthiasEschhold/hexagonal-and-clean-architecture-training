package de.arkem.clean.arc.demo.app.lab.e.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.usecase.in.VehicleQuery;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.usecase.out.VehicleRepository;

public class VehicleQueryService implements VehicleQuery {

    private final VehicleRepository repository;
    private final FetchVehicleMasterData fetchVehicleMasterData;

    //@Autowired
    public VehicleQueryService(VehicleRepository repository, FetchVehicleMasterData fetchVehicleMasterData) {
        this.repository = repository;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
    }

    @Override
    public Vehicle findByVin(Vin vin) {
        VehicleMasterData vehicleMasterData = fetchVehicleMasterData.fetch(vin);
        VehicleMotionData vehicleMotionData = repository.findVehicleMotionDataByVin(vin);
        return new Vehicle(vin, vehicleMotionData, vehicleMasterData);
    }
}
