import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchivioManager {
    private List<Dipendente> dipendenti;
    private List<Ufficio> uffici;

    public ArchivioManager() {
        dipendenti = new ArrayList<>();
        uffici = new ArrayList<>();
    }

    //carico di dati dal file
    public void caricaDatiDaFile(String nomeFile) {
        try(FileReader fileReader = new FileReader(nomeFile); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            //mentre la linea non è null, crea un oggetto dipendente
            String linea;
            while((linea = bufferedReader.readLine()) != null) {

                //prendo la linea e metto i valori in un vettore
                String[] dati = linea.split(";");
                if(dati.length > 0) {

                    //prendo i valori dalla linea e li metto nell'oggetto dipendente
                    if(dati[0].equals("Dipendente")) {
                        if(dati.length == 8) {
                            String dataNascita = dati[1];
                            String dataAssunzione = dati[2];
                            int oreLavoroSettimanali = Integer.parseInt(dati[3]);
                            String nome = dati[4];
                            String cognome = dati[5];
                            String indirizzo = dati[6];
                            String reparto = dati[7];

                            //metto il dipendente dentro alla lista dei dipendenti
                            dipendenti.add(new Dipendente(nome, cognome, indirizzo, dataNascita, dataAssunzione, oreLavoroSettimanali, reparto));
                        }

                    //prendo i valori della linea e li metto nell'oggetto ufficio
                    } else if(dati[0].equals("Ufficio")) {
                        if(dati.length == 6) {
                            String piano = dati[1];
                            String siglaLocale = dati[2];
                            int numPostazioni = Integer.parseInt(dati[3]);
                            String nome = dati[4];
                            String responsabile = dati[5];

                            //metto l'ufficio dentro alla lista degli uffici
                            uffici.add(new Ufficio(nome, piano, siglaLocale, numPostazioni, responsabile));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvaDatiSuFile(String nomeFile) {
        try(FileWriter fileWriter = new FileWriter(nomeFile); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            //salva sul file tutti i dipendenti
            for(Dipendente dipendente : dipendenti) {
                bufferedWriter.write(dipendente.toFileString());
                bufferedWriter.newLine();
            }

            //salva su file tutti gli uffici
            for(Ufficio ufficio : uffici) {
                bufferedWriter.write(ufficio.toFileString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void visualizzaDati() {

        //visualizza tutti i dipendenti
        System.out.println("Dipendenti:");
        for(Dipendente dipendente : dipendenti) {
            System.out.println(dipendente);
        }

        //visualizza tutti gli uffici
        System.out.println("\nUffici/Reparti:");
        for(Ufficio ufficio : uffici) {
            System.out.println(ufficio);
        }
    }
}
