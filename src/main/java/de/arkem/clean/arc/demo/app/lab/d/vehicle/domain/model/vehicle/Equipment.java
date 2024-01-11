package de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle;

public record Equipment(EquipmentCode equipmentCode, EquipmentLabel equipmentLabel) {

    public Equipment {
        validateEquipment(equipmentCode, equipmentLabel);
    }

    private void validateEquipment(EquipmentCode equipmentCode, EquipmentLabel equipmentLabel) {
        if (!isEquipmentValid(equipmentCode, equipmentLabel)) {
            throw new IllegalArgumentException("equipment is not valid");
        }
    }

    private boolean isEquipmentValid(EquipmentCode equipmentCode, EquipmentLabel equipmentLabel) {
        return equipmentCode != null && equipmentLabel != null;
    }
}
