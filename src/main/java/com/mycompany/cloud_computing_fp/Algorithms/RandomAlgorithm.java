/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author hnaji
 */
package com.mycompany.cloud_computing_fp.Algorithms;
import com.mycompany.cloud_computing_fp.Algorithm;
import com.mycompany.cloud_computing_fp.PM;
import com.mycompany.cloud_computing_fp.VM;
import java.util.List;
import java.util.Random;

public class RandomAlgorithm implements Algorithm {

    @Override
    public List<PM> placeVMs(List<VM> vms, List<PM> pms) {
        //am methoda la datatyp[e lista dw dana parametery haya bo hardw listy physical machin e w listy virtual machine 
        Random rand = new Random();//lerada la classy random ka yakeka la libraryakany java datwanyn ba shewayaky haramaky zhmara yan objctek hallbzheryn
        //lam for-each da basar da ba danay virtual macinakanda dagareyn w dan ba dana storyan dakain la naw listy vms boman stor dakat
        // dwatr loopeke rman danawa la naw while da hatakw pm eke gunjaw bo aw vm ay ka lam iterationada ba dastmmatawaya dadozetawa 
        // wata harktek vm alocate bw wata danra lasar pm awa break dabet w dawastet , hatakw aw vm allocate nabet 
        //loopy while aka dabeta infinate loop
        for (VM vm : vms) {
            while (true) {
                PM pm = pms.get(rand.nextInt(pms.size()));// am line pm ek ba shewayaky random halldabzheret la listy PM akan.
                //lam marjada  check akain ka aya aw yakam dana vm ayka lasar aw pm randomay hallman bzhardwa aya shwene dabetawa yan na 
                //agar je habw awa break bka agarysh nabw wata awkat hamw vm akan danrawn lasar pm akan w listy pm akanman bo dageretawa 
                if (pm.allocateVM(vm)) {
                    break;
                }
            }
        }
        return pms;
    }
}
