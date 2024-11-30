package com.mycompany.cloud_computing_fp;
import com.mycompany.cloud_computing_fp.Algorithms.FirstFitAlgorithm;
import com.mycompany.cloud_computing_fp.Algorithms.FirstFitDecreasingAlgorithm;
import com.mycompany.cloud_computing_fp.Algorithms.ProposedByMe;
import com.mycompany.cloud_computing_fp.Algorithms.RandomAlgorithm;
import java.util.ArrayList;
import java.util.List;
import utils.CSVWriter;
import utils.DataGenerator;
public class Cloud_Computing_FP {
    public static void main(String[] args) {
        // 
        int numVMs = 200; 
        int numPMs = 100; 
        int numRuns = 10; 
        List<VM> vms = DataGenerator.generateVMs(numVMs, 500, 4000);//.. am lista bo generate dakat ata boman drwst dakat ka la classy generator bangman krdotawa w lera parameterman pe dawa 
        List<PM> pms = DataGenerator.generatePMs(numPMs, 8000, 32000);
        runAlgorithm(new RandomAlgorithm(), vms, pms, numRuns, "random_results.csv");
        runAlgorithm(new FirstFitAlgorithm(), vms, pms, numRuns, "first_fit_results.csv");
        runAlgorithm(new FirstFitDecreasingAlgorithm(), vms, pms, numRuns, "first_fit_decreasing_results.csv");
        runAlgorithm(new ProposedByMe(), vms, pms, numRuns, "OptimalBinPackingAlgorithm_proposedByMe_Results.csv");
        System.out.println("All algorithms have been executed and results are saved.");
    }
    /*
This method signature defines a private static method named runAlgorithm.
The method takes five parameters: algorithm (an instance of the Algorithm interface),
    vms (a list of VMs), pms (a list of PMs),
    numRuns (the number of runs), and fileName (the name of the output file).*/
    private static void runAlgorithm(Algorithm algorithm, List<VM> vms, List<PM> pms, int numRuns, String fileName) {
        for (int i = 0; i < numRuns; i++) {
            List<VM> vmsCopy = new ArrayList<>(vms);
            List<PM> pmsCopy = new ArrayList<>(pms);
            //la kotaida aw placementay anjammman dawa lera listakai drwst dakain w la naw 
            //filek da day daneyn 
            List<PM> usedPMs = algorithm.placeVMs(vmsCopy, pmsCopy);
            CSVWriter.writeResults(fileName, usedPMs);
        }
    }}
