public class App {
    public static void main(String[] args) {
        ArchivioManager archivioManager = new ArchivioManager();
        archivioManager.caricaDatiDaFile("archivio.hyt");

        archivioManager.visualizzaDati();

        archivioManager.salvaDatiSuFile("archivio.hyt");
    }
}