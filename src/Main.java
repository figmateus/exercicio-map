import etities.Candidate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\Users\\Mateus\\Documents\\Java\\map\\in.txt";
        Map<String, Candidate> map = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String Candidate = br.readLine();
            while(Candidate != null) {
                String[] fields = Candidate.split(",");
                if(map.containsKey(fields[0])) {
                    Candidate currentCandidate = map.get(fields[0]);
                    Double Votes = currentCandidate.getVotes();
                    Votes += Double.parseDouble(fields[1]);
                    currentCandidate.setVotes(Votes);
                    map.put(fields[0], currentCandidate);
                } else {
                    map.put(fields[0], new Candidate(fields[0], Double.parseDouble(fields[1])));
                }
                Candidate = br.readLine();
            }

            for(Map.Entry<String, Candidate> key : map.entrySet()){
                Candidate candidate = key.getValue();
                Double votes = candidate.getVotes();
                System.out.println("O candidato(a) "+ key.getKey() + " Teve um total de: "+ votes+" Votos");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}