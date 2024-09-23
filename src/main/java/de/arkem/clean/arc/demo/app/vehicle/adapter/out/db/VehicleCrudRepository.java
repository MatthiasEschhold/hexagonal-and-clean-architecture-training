package de.arkem.clean.arc.demo.app.vehicle.adapter.out.db;

import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCrudRepository /*extends CrudRepository<VehicleDbEntity, String>*/ {

    //@Modifying
    //@Query("UPDATE vehicle SET licensePlate = :licensePlate WHERE ID = :ID")
    boolean updateLicensePlate(/*@Param("ID")*/ String id, /*@Param("licensePlate")*/ String licensePlate);

    //@Query("SELECT * FROM vehicle WHERE licensePlate = :licensePlate")
    boolean findByLicensePlate(/*@Param("licensePlate")*/ String licensePlate);

    VehicleDbEntity save(VehicleDbEntity vehicle);
}