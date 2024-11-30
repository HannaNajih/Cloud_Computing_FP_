/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cloud_computing_fp;

/**
 *
 * @author hnaji
 */

import java.util.List;
public interface Algorithm {
    // ba hoy am methoda overrida awa datwanyn bo har algorithmek 
    // ba shewayak vm yan pm kan ba shewazy karkrdny algorithmaka rek bxaayn
    List<PM> placeVMs(List<VM> vms, List<PM> pms);
}
