package bd;


import com.vetpet.bean.Consulta;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class Dados {
    public static List<Consulta> consultas = new ArrayList<>();
    
    public static List<String> datasPossiveis(){
        List<String> datas = new ArrayList<String>();
        Calendar hoje = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for(int i = 0; i< 6; i++){
            hoje.set(Calendar.DATE, hoje.get(Calendar.DATE) + 1);
            datas.add(df.format(hoje.getTime()));
        }
        return datas;
    }
    
    public static List<String> medicos(){
        List<String> med = new ArrayList<String>();
        
        med.add("Maria");
        med.add("Joao");
        med.add("Jose");
        med.add("Flavio");
        med.add("Marcos");
        
        return med;
    }
}
