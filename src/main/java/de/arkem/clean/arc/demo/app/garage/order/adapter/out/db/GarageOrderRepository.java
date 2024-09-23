package de.arkem.clean.arc.demo.app.garage.order.adapter.out.db;

import de.arkem.clean.arc.demo.app.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.app.garage.order.usecase.out.GarageOrderDbCommand;
import de.arkem.clean.arc.demo.app.garage.order.usecase.out.GarageOrderDbQuery;
import de.arkem.clean.arc.demo.app.garage.order.domain.model.OrderNumber;

import java.util.List;
import java.util.Optional;

class GarageOrderRepository implements GarageOrderDbCommand, GarageOrderDbQuery {
    @Override
    public GarageOrder save(GarageOrder garageOrder) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Optional<GarageOrder> findByOrderNumber(OrderNumber orderNumber) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<GarageOrder> findAll() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
