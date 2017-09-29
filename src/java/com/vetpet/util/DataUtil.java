package com.vetpet.util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author elielsonms
 */
public class DataUtil {
    private static final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    
    public static String formatar(Date data){
        return df.format(data);
    }
    
    
    public static void main(String[] args){
        System.out.println(DataUtil.formatar(new Date()));
    }
    
}
