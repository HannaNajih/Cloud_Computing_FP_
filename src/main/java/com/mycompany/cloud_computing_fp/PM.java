/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cloud_computing_fp;

/**
 *
 * @author hnaji
 */
//classakaman publica atwanret la layan har classeke trawa accessy bo habet w propertiakani bakar bhenret

public class PM {
private int id;// am variable bo store krdny id behawtay har yakek la physical machine akanmana 
private int capacity;// am variable bo pshandany twanay computationy har physical machineka ka ba MIPS dapewret
private int availableCapacity;//bakary dahenin bo chawderykrdny twanay maway computation ka la naw har physical machinekda haya
//am constructora drwst dakain takw la shweneke tr ba hoy nardny nrx la objecty am classawa btwanyn nrx bdayn ba variable akan 
public PM(int id,int capacity){
this.id=id;
this.capacity=capacity;
this.capacity=availableCapacity;
//la saratada ema available capacityman har haman capacitya chunka hychy nagirawa 
//bo nmuna capacyty pm ekman 32, 2 adayn ba vm kawata capacity abeta 30, kawata 
//away ka la bardastmana mawa har 30 wata available capacity har 30 
}

//am methoda getterana bo wargrtnaway datay setkrawy naw 
//constructory sarawaya 
public int getId(){
return id;}
public int getCapacity(){
return capacity;}
public int getAvailableCapacity(){
return availableCapacity;}
 //am methoda bo check krdny awaya ka aya ema shwenman haya la naw PM da takw VM da bneyn?
    //agar true bgeretawa wata shwenman haya, wata availableCapacity buny haya bashy computationy VM aka dakat 
    public boolean allocateVM(VM vm){//intancek yan objectek la classy VM wardagryn takw btwanyn access bkain bo methode getRequirement()
    if(vm.getRequirement()<=availableCapacity){
        //lam marjada dallein :  aw twanaw hezay physical machine aka ka bo virtuak machinaka dabin krawa 
        //la availableCapacity dary ka takw bzanin chane shwene tr la physical machinaka mawa takw vm y try bxayna sar 
      //datwanyn bam shewayash am deray xwarawa bnwsyn ballam awa bo mn rwntr bw :
      //availableCapacity -=vm.getRequirements;
    availableCapacity=vm.getRequirement()-vm.getRequirement();
    return true;}
    return false;
    }
}
