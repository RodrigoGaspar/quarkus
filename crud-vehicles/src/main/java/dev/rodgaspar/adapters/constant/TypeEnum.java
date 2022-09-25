package dev.rodgaspar.adapters.constant;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TypeEnum {

    CAR("car"),
    BIKE("bike");

    @Getter 
    private String label;

    private static final Map<String, TypeEnum> BY_LABEL = new HashMap<>();
    
    static {
        for (TypeEnum e: values()) {
            BY_LABEL.put(e.label, e);
        }
    }

    public static TypeEnum valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

}
