class Cabina {

    private int nroCabina;
    private Persona[] personasAbordo;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        personasAbordo = new Persona[10];
    }

    public int getNroCabina() { return nroCabina; }
    public Persona[] getPersonasAbordo() { return personasAbordo; }

    public void agregarPersona(Persona p) {

        int contador = 0;
        float sumaPeso = 0;

        for (int i = 0; i < personasAbordo.length; i++) {
            if (personasAbordo[i] != null) {
                contador++;
                sumaPeso += personasAbordo[i].getPesoPersona();
            }
        }

        if (contador == 10) {
            System.out.println("Cabina " + nroCabina + " llena");
            return;
        }

        if (sumaPeso + p.getPesoPersona() > 850) {
            System.out.println("Cabina " + nroCabina + " sobrepeso");
            return;
        }

        for (int i = 0; i < personasAbordo.length; i++) {
            if (personasAbordo[i] == null) {
                personasAbordo[i] = p;
                break;
            }
        }
    }
}
