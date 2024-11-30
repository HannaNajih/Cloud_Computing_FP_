/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
/**
 *
 * @author hnaji
 */
import com.mycompany.cloud_computing_fp.VM;
import com.mycompany.cloud_computing_fp.PM;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class DataGenerator {//am classa bo drwst krdn wata generate krdny liste VM w listy PM akana
    public static List<VM> generateVMs(int count, int minReq, int maxReq) {//am methda bo zhmardny aw Vm anay ka generate dakat ba variable count
        //kamtryn pedawysty bo VM ba variable minReq, zortryn pewesty Vm ba variable maxReq
        List<VM> vms = new ArrayList<>();
        Random rand = new Random();//requiremantaka ba shewayakky random drwst dakret bam objecta(rand)
        for (int i = 0; i < count; i++) {
            //variabe rand la classy radoawa warman grtwa ka zhmaraman la rangeke dyary kraw ba haramaky bo wargret
            //methode rand.nextInt() ama ba sheway zhmaray tawaw  zhmaraman bo wargdagret
            //maxReq-minReq am hawkeshaya range available y zhmaaray requirementakanman pe dadat 
            //boya +1 dakain la halatekda agar sfr bw aw yaka wakw default value dabnet
            
            /* Step-by-Step Calculation:

Range Calculation: maxReq - minReq + 1 = 1000 - 500 + 1 = 501.

Random Number Generation: rand.nextInt(501) generates a random integer between 0 and 500.

Adjusting the Range: Adding minReq shifts the random number to be between 500 and 1000.
            */
            
            int requirement = rand.nextInt(maxReq - minReq + 1) + minReq;
            //am line xwarawa VM ek drwst dakat ba ID iterationy for akai ka hamana wata yakam danay id (0) dadate 
            vms.add(new VM(i, requirement));
        }
        return vms;
    }

    public static List<PM> generatePMs(int count, int minCap, int maxCap) {
        List<PM> pms = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            int capacity = rand.nextInt(maxCap - minCap + 1) + minCap;
            pms.add(new PM(i, capacity));
        }
        return pms;
    }
}
