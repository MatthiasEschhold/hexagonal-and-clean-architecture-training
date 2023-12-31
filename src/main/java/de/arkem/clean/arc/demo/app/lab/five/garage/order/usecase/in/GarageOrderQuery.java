package de.arkem.clean.arc.demo.app.lab.five.garage.order.usecase.in;

import de.arkem.clean.arc.demo.app.lab.five.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.app.lab.five.garage.order.domain.model.OrderNumber;

public interface GarageOrderQuery {
    GarageOrder read(OrderNumber orderNumber);
}
