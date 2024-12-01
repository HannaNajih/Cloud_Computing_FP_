# Virtual Machine Placement in Cloud Computing

## Overview

This project implements several algorithms for virtual machine (VM) placement in cloud computing environments. The goal is to efficiently allocate VMs to physical machines (PMs) to optimize resource usage and minimize costs.

## Algorithms Implemented

1. **Random Algorithm**: This algorithm randomly selects PMs for VM placement.
2. **First-Fit Algorithm**: This algorithm places each VM in the first PM that has enough capacity to host it.
3. **First-Fit Decreasing Algorithm**: This algorithm sorts VMs by their computational requirements in decreasing order and then applies the First-Fit strategy.
4. **Optimal Bin Packing Algorithm**: A custom algorithm proposed by the developer to optimize VM placement using bin packing techniques.

## Project Structure

- **src/main/java/com/mycompany/cloud_computing_fp/**:
  - `Algorithms/`:
    - `RandomAlgorithm.java`: Implements the random VM placement algorithm.
    - `FirstFitAlgorithm.java`: Implements the first-fit VM placement algorithm.
    - `FirstFitDecreasingAlgorithm.java`: Implements the first-fit decreasing VM placement algorithm.
    - `OptimalBinPackingAlgorithm.java`: Implements the custom optimal bin packing algorithm.
  - `DataGenerator.java`: Utility class to generate random VMs and PMs.
  - `CSVWriter.java`: Utility class to write results to a CSV file.
  - `Cloud_Computing_FP.java`: Main class to run the algorithms and save results.

## Usage

1. **Generate VMs and PMs**:
   - Use the `DataGenerator` class to generate random VMs and PMs with specific requirements and capacities.

2. **Run Algorithms**:
   - Call the `runAlgorithm` method to execute each algorithm and save the results to a CSV file.

3. **Analyze Results**:
   - The results are saved in CSV files, which can be analyzed to compare the performance of different algorithms.

## Sample Code

```java
public class Cloud_Computing_FP {
    public static void main(String[] args) {
        // Set up parameters
        int numVMs = 200; // Number of VMs
        int numPMs = 100; // Number of PMs
        int numRuns = 10; // Number of runs for accuracy
        List<VM> vms = DataGenerator.generateVMs(numVMs, 500, 4000);
        List<PM> pms = DataGenerator.generatePMs(numPMs, 8000, 32000);
        runAlgorithm(new RandomAlgorithm(), vms, pms, numRuns, "random_results.csv");
        runAlgorithm(new FirstFitAlgorithm(), vms, pms, numRuns, "first_fit_results.csv");
        runAlgorithm(new FirstFitDecreasingAlgorithm(), vms, pms, numRuns, "first_fit_decreasing_results.csv");
        runAlgorithm(new OptimalBinPackingAlgorithm(), vms, pms, numRuns, "optimal_bin_packing_results.csv");
        System.out.println("All algorithms have been executed and results are saved.");
    }
    private static void runAlgorithm(Algorithm algorithm, List<VM> vms, List<PM> pms, int numRuns, String fileName) {
        for (int i = 0; i < numRuns; i++) {
            List<VM> vmsCopy = new ArrayList<>(vms);
            List<PM> pmsCopy = new ArrayList<>(pms);
            List<PM> usedPMs = algorithm.placeVMs(vmsCopy, pmsCopy);
            CSVWriter.writeResults(fileName, usedPMs);
        }
    }
}
