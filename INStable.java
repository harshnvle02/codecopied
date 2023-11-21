
package anuspos;

import java.util.HashMap;

public class INStable
{
    HashMap<String, Integer> IS,AD,RG,DL;
    public INStable()
    {
        IS=new HashMap<>();
        AD=new HashMap<>();
        RG=new HashMap<>();
        DL=new HashMap<>();
        
        AD.put("START",1);
        AD.put("END",2);
        AD.put("ORIGIN",3);
        AD.put("EQU",4);
        
        DL.put("DC", 1);
        DL.put("DS",2 );
        
        IS.put("ADD",1);
        IS.put("SUM",2);
        IS.put("MULT",3);
        IS.put("MOVER",4);
        IS.put("MOVEM",5);
        IS.put("COMP",6);
        IS.put("BC",7);
        IS.put("DIV",8);
        IS.put("READ",9);
        IS.put("PRINT",10);
        IS.put("STOP",00);
        
        RG.put("AGEG",1);
        RG.put("BGEG",2);
        RG.put("CGEG",3);
        RG.put("DGEG",4);
        
        
    }
    public String getType(String s)
    {
        if(AD.containsKey(s))
            return"AD";
        else if(DL.containsKey(s))
            return"DL";
        else if(RG.containsKey(s))
            return"RG";
        else if(IS.containsKey(s))
            return"IS";
        else
            return" ";
                        
        
    }
    public Integer getCode(String s)
    {
        if(AD.containsKey(s))
            return AD.get(s);
        else if(DL.containsKey(s))
            return DL.get(s);
        else if(RG.containsKey(s))
            return RG.get(s);
        else if(IS.containsKey(s))
            return IS.get(s);
        else
            return -1;
    }
    
    
}
