package com.mycompany.cloud_computing_fp;
import com.mycompany.cloud_computing_fp.Algorithms.FirstFitAlgorithm;
import com.mycompany.cloud_computing_fp.Algorithms.FirstFitDecreasingAlgorithm;
import com.mycompany.cloud_computing_fp.Algorithms.ProposedByMe;
import com.mycompany.cloud_computing_fp.Algorithms.RandomAlgorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.CSVWriter;
import utils.DataGenerator;
public class Cloud_Computing_FP {

    //private static Object algorithm;
    public static void main(String[] args) {
        //this is second scenario
        Scanner sc=new Scanner(System.in);
        System.out.println("enter 1 for scenario one: Virtual machines are 250, physical machines are 100 \n "
                + "enter 2 for scenario two: Virtual machines are 150, physical machines are 200");
        int chooseScenario=sc.nextInt();
        System.out.println("you choose : "+chooseScenario);
        switch(chooseScenario){
                case 1 :
                        System.out.print(scenarioOne(250,100));
                case 2: 
                    System.out.print(scenarioTwo(200,150));
                default: System.out.println(" just enter 1 or 2 ");
        }
        //this is first scenario
        int numVMs = 250; 
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
    }

 static int scenarioOne(int numVMs,int numPMs){

 return 1;
 }

 static int scenarioTwo(int numVMs,int numPMs){

return 2;}
}
