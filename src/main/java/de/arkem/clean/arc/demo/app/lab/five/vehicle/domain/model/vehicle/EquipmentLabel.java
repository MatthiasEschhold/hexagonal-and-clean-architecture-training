package de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle;

public record EquipmentLabel(String value) {
    public EquipmentLabel {
        validateEquipmentLabel(value);
    }

    private void validateEquipmentLabel(String value) {
        if (!isValidEquipmentLabel(value)) {
            throw new IllegalStateException("equipment label is not valid");
        }
    }

    private boolean isValidEquipmentLabel(String value) {
        return value != null && !value.isBlank();
    }
}
