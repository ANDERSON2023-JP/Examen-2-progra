class Linea {

    private String color;
    private Persona[] filaPersonas;
    public Cabina[] cabinas;
    public int cantidadCabinas;

    public Linea(String color) {
        this.color = color;
        filaPersonas = new Persona[50];
        cabinas = new Cabina[20];
        cantidadCabinas = 0;
    }

    public String getColor() {
        return color;
    }

    public void agregarPersona(Persona p) {
        for (int i = 0; i < filaPersonas.length; i++) {
            if (filaPersonas[i] == null) {
                filaPersonas[i] = p;
                break;
            }
        }
    }

    public void agregarCabina(int nroCab) {
        cabinas[cantidadCabinas] = new Cabina(nroCab);
        cantidadCabinas++;
    }
}