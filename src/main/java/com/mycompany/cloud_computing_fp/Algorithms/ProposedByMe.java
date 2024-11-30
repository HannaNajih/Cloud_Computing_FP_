/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cloud_computing_fp.Algorithms;
//pewesta package akkaman lera bang bkainawa takw aw classanay ka la nawda haya 
//pewest naka ba jya importy haryakekyan bkayn
import com.mycompany.cloud_computing_fp.Algorithm;
import com.mycompany.cloud_computing_fp.PM;
import com.mycompany.cloud_computing_fp.VM;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author hnaji
 */
//OptimalBinPackingAlgorithm this algorithm that i propose to place the virtual machoines on physical machines
//am algoritmay ka mn bakarm henawa ba xerayyaki zortr datwanet computation bkat w memmory kamtrysh bgret
//la file sarchawakan linkakaim wakw reference danawa
public class ProposedByMe implements Algorithm {

    @Override
    //..am methoda ovveride bo danany virtual machine akan lasar physical machinakan
    public List<PM> placeVMs(List<VM> vms, List<PM> pms) {
        //sort krdn yan rezkrdny virtual machinakan lasar physical mahinakan ba sheway deecreasing wata la gawrawa bo bchuk boman rez dakat 
        //am methoda sorty vms dakat ba bakar henany classy comparator, am classa bo barawrd krdn*muqayasakrdny* dw object ka waryan dagryn la vms
        
        Collections.sort(vms, new Comparator<VM>() {
            @Override
        //am anotationay overide bo pedany bodya ba methody naw cllasy Comparator 
            //ka nterfaceka methodaai tedaya tanh declare krawa lera initialize akain
            public int compare(VM vm1, VM vm2) {
                return Integer.compare(vm2.getRequirement(), vm1.getRequirement());
            }//lerada dw objectaka ka vm1 w vm 2  barawrdyan akain , lerada dway barawrd krdneke ordery hardw vm dagarenetawa boman 
            //lasar sheway zhmaray tawaw Integer,lerada braward dakat agar vm2 gawratr bet la vm1 awa sarata vm2 dadanet lasar physical machinaka 
            //amash pey dawtret ryzkrdn la gawrawa bo bchuk wata decreasing
        });//katek vm2 requirementakani gawratrn w zyatr shwen agrn la awanai vm1 awa valuey positive man bo dageretawa

        for (VM vm : vms) {
            //ama (for each)a basar hamw vmakanda dagaret la naw listy vms akanda bunyan haya w dwatr awanay ka traverse krdwa basaryanda store yan dakat la naw listakada 
            
            PM bestFitPM = null;//am variabla bo monitor krdn w chawdere krdny physical machine akan bakar det ka bashtrena bo aw virtual machinay ka la estada la for akada run abet wata current vm 
            //am variable ay xwarawa bakar det bo chawdere krdny aw boshayyay yan aw twanay computationay ka lasar physical machinaka mawatawa wata jey xalli bo vm eke tr
            int minRemainingCapacity = Integer.MAX_VALUE;
//lam for-each ada basar haryak la physical machin akanda dagaret wa aw iteanai ka basaryana garawa la naw objecty pm ka la classy PM drwstman krdwa w dway iterate krdn basaryanda store yan dakat
//am lista la naw pms da save dakret ba hoy am listawa la xwarawa access man dabet bo aw  physical machianay ka check krawn w iterate krawn
            for (PM pm : pms) {
                int remainingCapacity = pm.getAvailableCapacity() - vm.getRequirement();
                //calculate pm aka dakat dway alocate krdny vm aka, wata sere dakat bzane chanek jegay xalliman mawa bo danany vm y tr
                 //remainingCapacity am variable bakardahenret bo garandnaway boshay habww la naw pm akanda dway away ka allocate krdwa bo vm 
      
                if (remainingCapacity >= 0 && remainingCapacity < minRemainingCapacity) {
                   
                    bestFitPM = pm;
                    minRemainingCapacity = remainingCapacity;
                }
            }
//ba gshty bam  nested loopana bo dozinaway bashtren physical machine dagaret, agar pm gunjaw nadozretawa awa vm alocate nabet wta vm dananret lasar hych pm ek.
            if (bestFitPM != null) {
                bestFitPM.allocateVM(vm);
            } else {
                // amash aw case aya ka aleyn hych shwenek namawatawa w am vm natwanet lasar hych yakek la pm akan danishet
                System.out.println("VM " + vm.getId() + " could not be allocated.");
            }
        }
        return pms;
    }
}
/*

### Summary
This implementation leverages the key ideas from Korf's bin packing algorithm, 
improving the efficiency by sorting the VMs in decreasing order of their requirements 
and then applying a best-fit strategy to allocate them to PMs.

By placing this code in your project, you can test the performance of this algorithm alongside 
the other algorithms you have implemented. 
*/