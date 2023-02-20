package main.Jauges;

import main.TypeJauge;

import java.util.HashMap;

public class JaugeManager {
    protected HashMap <TypeJauge, Integer> jauges;

    public JaugeManager(HashMap<TypeJauge, Integer> jauges) {
        this.jauges = jauges;
    }
}
