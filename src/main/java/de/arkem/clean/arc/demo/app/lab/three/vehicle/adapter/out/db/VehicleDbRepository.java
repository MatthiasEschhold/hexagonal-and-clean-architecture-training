package de.arkem.clean.arc.demo.app.lab.three.vehicle.adapter.out.db;

import de.arkem.clean.arc.demo.app.lab.three.vehicle.usecase.out.VehicleRepository;
import de.arkem.clean.arc.demo.app.lab.three.vehicle.domain.model.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.three.vehicle.domain.model.Vin;

public class VehicleDbRepository implements VehicleRepository {

    private final VehicleToDbEntityDbMapper dbEntityMapper;
    private final VehicleToEntityDbMapper entityMapper;
    private final VehicleCrudRepository crudRepository;

    public VehicleDbRepository(VehicleToDbEntityDbMapper dbEntityMapper, VehicleToEntityDbMapper entityMapper, VehicleCrudRepository crudRepository) {
        this.dbEntityMapper = dbEntityMapper;
        this.entityMapper = entityMapper;
        this.crudRepository = crudRepository;
    }

    @Override
    public void save(Vin vin, VehicleMotionData vehicleMotionData) {
        crudRepository.save(dbEntityMapper.mapVehicleToDbEntity(vin, vehicleMotionData));
    }

}
