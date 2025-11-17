class MiTeleferico {

    private Linea[] lineas;
    private float cantidadIngresos;

    public MiTeleferico() {
        lineas = new Linea[3];
        lineas[0] = new Linea("Amarilla");
        lineas[1] = new Linea("Roja");
        lineas[2] = new Linea("Verde");
        cantidadIngresos = 0;
    }

    public void agregarPersonaFila(Persona p, String linea) {
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i].getColor().equalsIgnoreCase(linea)) {
                lineas[i].agregarPersona(p);
            }
        }
    }

    public void agregarCabina(String linea) {
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i].getColor().equalsIgnoreCase(linea)) {
                lineas[i].agregarCabina(lineas[i].cantidadCabinas + 1);
            }
        }
    }

    // A) Agregar primera persona
    public void agregarPrimeraPersona(int nroCabina, Persona p) {
        for (Linea linea : lineas) {
            for (int j = 0; j < linea.cantidadCabinas; j++) {
                if (linea.cabinas[j].getNroCabina() == nroCabina) {
                    linea.cabinas[j].agregarPersona(p);
                    return;
                }
            }
        }
    }

    // B) Verificar reglas
    public void verificarReglasAbordo() {

        for (Linea linea : lineas) {
            for (int j = 0; j < linea.cantidadCabinas; j++) {

                Cabina c = linea.cabinas[j];
                int contador = 0;
                float pesoTotal = 0;

                for (Persona p : c.getPersonasAbordo()) {
                    if (p != null) {
                        contador++;
                        pesoTotal += p.getPesoPersona();
                    }
                }

                if (contador > 10) {
                    System.out.println("Cabina " + c.getNroCabina() + " superó límite de personas");
                }

                if (pesoTotal > 850) {
                    System.out.println("Cabina " + c.getNroCabina() + " tiene sobrepeso");
                }
            }
        }
    }

    // C) Calcular ingreso
    public float calcularIngreso() {

        cantidadIngresos = 0;

        for (Linea linea : lineas) {
            for (int j = 0; j < linea.cantidadCabinas; j++) {

                Cabina c = linea.cabinas[j];

                for (Persona p : c.getPersonasAbordo()) {
                    if (p != null) {

                        if (p.getEdad() < 25)
                            cantidadIngresos += 1;
                        else if (p.getEdad() > 60)
                            cantidadIngresos += 1.5;
                        else
                            cantidadIngresos += 3;
                    }
                }
            }
        }

        return cantidadIngresos;
    }

    // D) Línea con más ingreso regular
    public void mostrarLineaMasIngreso() {

        float[] ingresosLinea = new float[3];

        for (int i = 0; i < lineas.length; i++) {
            ingresosLinea[i] = 0;

            for (int j = 0; j < lineas[i].cantidadCabinas; j++) {

                Cabina c = lineas[i].cabinas[j];

                for (Persona p : c.getPersonasAbordo()) {
                    if (p != null) {
                        if (p.getEdad() >= 25 && p.getEdad() <= 60) {
                            ingresosLinea[i] += 3;
                        }
                    }
                }
            }
        }

        int pos = 0;
        for (int i = 1; i < ingresosLinea.length; i++) {
            if (ingresosLinea[i] > ingresosLinea[pos]) {
                pos = i;
            }
        }

        System.out.println("La línea con mayor ingreso regular es: " + lineas[pos].getColor());
    }
}
