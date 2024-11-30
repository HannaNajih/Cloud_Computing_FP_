/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cloud_computing_fp.Algorithms;
/**
 *
 * @author hnaji
*/
import com.mycompany.cloud_computing_fp.Algorithm;// inteface akgorithm ka drwstman krdwa led=ra dabet dasrrasyman boy habet
import com.mycompany.cloud_computing_fp.PM;//am file listy physical machinakanman bo manage dakat
import com.mycompany.cloud_computing_fp.VM;//am file listy virtual machinakanman bo manage dakat
import java.util.Collections;// am classa la naw javada bo dast peragayshtna ba handel la methoda grngakan wakw sorting ka ema lerada pewestman peyaty.
import java.util.Comparator;//amayan bo importkrdny interface comparator ka yakeka la standard libraryakany java har wakw collection, bo wargrtny aw dww dana objectay ka ba collection sortman krdwn pekawa mwqayasay bkat wata barawrdy  bkat 
import java.util.List;//jorek la data structure ka atwanyn itemy teda store bkain , w length fixed nia datwanen la sarataw kotay w nawarastda itemy bo zyad kain

public class FirstFitDecreasingAlgorithm implements Algorithm {

    @Override
    public List<PM> placeVMs(List<VM> vms, List<PM> pms) {
        // am methoda ka nawe placeVM dw dana arametery haya /. ka listeka la VM akan ba nawe vms wa listek la PM akan ka nawe pms 
        Collections.sort(vms, new Comparator<VM>() {
//lerada aw liste vms anai ka warman grtwa pekawa barawrdyan dakain ba pey qyasy pewestyan ba computation la gawrrawa bo bchukmwata kamian zyatr kat w shwen w memory pewesta awayan sarata dadaneyn
            @Override
            public int compare(VM vm1, VM vm2) {
                //am methoda bo dyarykrdny order wata rezbandy vms akana wata kamian gawra bw awayan sarata dadanet, la gawrawa bo bchuk reze dakat
                return Integer.compare(vm2.getRequirement(), vm1.getRequirement());
            }
        });

        // amash First-Fit strategya, for-each bakar ahenyn bo garan basar dana ba danay virtual machinakan//lerada am variably pm bo wargrtny aw virtual machinaya ka la yak iterationy forakata 
        //ba dastmanawaya wa harwaha variable pm aw objetay la physical machinakai ka haana bo am iterationay ba dastmanawaya 
        for (VM vm : vms) {
            for (PM pm : pms) {
                if (pm.allocateVM(vm)) {//am dera coda peman dallet agar aw physical machiay hamana 
                    //jegay aw vm ka hamana lam iterationada jey abetawa yan na 
                    //agar jega habet awa true man bo dageretawa ballam agar wa nabw false man bo dageretawa 
                    break;// am statementy break zor grnga rega dagret la infinate loop 
                   //am statementa for-eachakay nawawaman bo dawastenet, w dllnyaman dakatawa laway har 
                   //virtual machinek lasar physical machinek da nrawa ba shewayakay drwst 
                   /// har m ek da nrawa lasar yakamin pm y gunjaw 
                }
            }
        }
        return pms;
    }
}
