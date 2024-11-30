/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author hnaji
 */
import java.io.FileWriter;//am classa bo nusyny file bakar dahenret la javada file akani ba sheway character danwst w store dakat
import java.io.IOException;//am cassash bo hande krdny exceptiona wata takw runtime errorakanman hande kain 
import java.util.List;// aw datayanay hamana la naw data structure listda save bkain 
import com.mycompany.cloud_computing_fp.PM;
public class CSVWriter {// am classa arky nwsyny file kani csv man bo dagreta asto

    public static void writeResults(String filePath, List<PM> pms) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("PM ID,Capacity,Available Capacity\n");//am line header row y file nusrawa ka resulty haryak la algorithmakan danwset
            for (PM pm : pms) {//lerada ba listek physical machina akan wardagrenawa ka vm akanman lasar danawa takw amai teda bnwsyn
                //identity physical machinaka ka be hawtaya w jiai dakatawa la physical machinakani deka
                //wa twanay computationyakai ka ba capacity dyaryman krdwa 
                //wa aw shwenay ka mawyaty takw virtual machiny tr warbgret
                writer.write(pm.getId() + "," + pm.getCapacity() + "," + pm.getAvailableCapacity() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//ema lerada blocky try-catch bakar dahenyn takw pesh rwndany har runtime errorek ema 
//peshy pe bgryn w nahelyn rww bdat la halatekda agar programakaman run bw w file akani nanwsy aw kat 
//la katy run bwnda tushy crash nabet , agar operationy trman habe dway am, ba be kesha run bn w bo kate trouble shooting asana azanyn 
//xalal la kaweya zw haly akain, methody stacktrace yak ba yaky keshakanman ba ryzbandy bo print dakat amash wa dakat bzanyn la kwewa keshakan hatwn w charasaryan kain 