package com.mycompany.cloud_computing_fp.Algorithms;
import com.mycompany.cloud_computing_fp.Algorithm;
import com.mycompany.cloud_computing_fp.PM;
import com.mycompany.cloud_computing_fp.VM;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author hnaji
 */
public class FirstFitAlgorithm implements Algorithm {
    @Override
    public List<PM> placeVMs(List<VM> vms, List<PM> pms) {
        //am methoda la data type lista ka yakeka la methoda be body akany naw interface algorithm
        for (VM vm : vms) {
            for (PM pm : pms) {
                if (pm.allocateVM(vm)) {
                    break;
                }
            }
        }
        return pms;
    }
}
