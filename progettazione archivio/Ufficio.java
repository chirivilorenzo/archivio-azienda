public class Ufficio {
    private String nome;
    private String piano;
    private String siglaLocale;
    private int numPostazioni;
    private String responsabile;

    public Ufficio(String nome, String piano, String siglaLocale, int numPostazioni, String responsabile) {
        this.nome = nome;
        this.piano = piano;
        this.siglaLocale = siglaLocale;
        this.numPostazioni = numPostazioni;
        this.responsabile = responsabile;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " Piano: " + piano + " Sigla Locale: " + siglaLocale + " Numero di postazioni: " + numPostazioni + " Responsabile: " + responsabile;
    }

    public String toFileString() {
        return "Ufficio;" + piano + ";" + siglaLocale + ";" + numPostazioni + ";" + nome + ";" + responsabile;
    }
}