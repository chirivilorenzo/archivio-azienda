public class Dipendente {
    private String nome;
    private String cognome;
    private String indirizzo;
    private String dataNascita;
    private String dataAssunzione;
    private int oreLavoroSettimanali;
    private String reparto;

    public Dipendente(String nome, String cognome, String indirizzo, String dataNascita, String dataAssunzione,int oreLavoroSettimanali, String reparto) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.dataNascita = dataNascita;
        this.dataAssunzione = dataAssunzione;
        this.oreLavoroSettimanali = oreLavoroSettimanali;
        this.reparto = reparto;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " Cognome: " + cognome + " Indirizzo: " + indirizzo + " Data di nascita: " + dataNascita + " Data di assunzione: " + dataAssunzione + " Ore di lavoro settimanali: " + oreLavoroSettimanali + " Reparto: " + reparto;
    }

    public String toFileString() {
        return "Dipendente;" + dataNascita + ";" + dataAssunzione + ";" + oreLavoroSettimanali + ";" + nome + ";" + cognome + ";" + indirizzo + ";" + reparto;
    }
}