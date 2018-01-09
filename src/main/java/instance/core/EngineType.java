package instance.core;

public enum EngineType {
    DERBY, HYPERSQL;
    public static EngineType fromString(String value) {
        if (value.isEmpty()) {
            return null;
        }
        try {
            switch (Integer.valueOf(value)) {
                case 0:
                    return DERBY;
                case 1:
                    return HYPERSQL;
                default:
                    return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
