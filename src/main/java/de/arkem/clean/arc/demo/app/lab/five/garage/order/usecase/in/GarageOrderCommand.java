package de.arkem.clean.arc.demo.app.lab.five.garage.order.usecase.in;

import de.arkem.clean.arc.demo.app.lab.five.garage.order.domain.command.CreateGarageOrderCommand;
import de.arkem.clean.arc.demo.app.lab.five.garage.order.domain.command.UpdateGarageOrderCommand;
import de.arkem.clean.arc.demo.app.lab.five.garage.order.domain.model.GarageOrder;

public interface GarageOrderCommand {
    GarageOrder create(CreateGarageOrderCommand createGarageOrderCommand);

    GarageOrder update(UpdateGarageOrderCommand updateGarageOrderCommand);
}
