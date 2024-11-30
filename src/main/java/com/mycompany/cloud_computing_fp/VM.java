/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cloud_computing_fp;

/**
 *
 * @author hnaji
 */
public class VM {
    //bo nasandny har yak la virtual machine akan pewesta nawyan bzanyn wata id
   //wa bo zaniny aw pewestyanay ka dayawet pewestman ba variable requiremt haya 
    //lera ba getter w setter method daman nawn ka la laiani security yarmatyman dadat
    //wa bo pekani jore nusyny clean code bam shewaya nusewmana takw la dwayda gorankary update krdnaway asan bet 
    
    int id;
    int requirement;
    public VM(int id, int requirement){
    this.id=id;
    this.requirement=requirement;
    }
    
    public int getId(){
    return id;}
    public int getRequirement(){
    return requirement;}
   
}
