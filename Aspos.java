package anuspos;

import java.util.*;
import java.io.*;


public class Aspos
{
     static LinkedHashMap<String,TableRow> SYMTAB;
    
    public static void main(String[] args) throws Exception 
    {
        SYMTAB = new LinkedHashMap < >();
        INStable lookup=new INStable();
        
        
        String line,code;
        int LC=0;
        int symIndex=0;
        BufferedReader br=new BufferedReader(new FileReader("/home/d7/aa"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("/home/d7/IC"));
        
        while((line=br.readLine())!=null)
        {
             
            String parts[]=line.split("\\s+");
            System.out.println(parts[1]);
            if(parts[1].equals("START"))
            {
                LC=Integer.parseInt(parts[2]);
                code="(AD,01) \t (C,"+LC+")";
                bw.write(code+"\n");
            }
            if(parts[1].equals("END"))
            {
                
                code="(AD,02)";
                bw.write(code+"\n");
            }
            if(!parts[0].isEmpty())
            {
                if (SYMTAB.containsKey(parts[0]))
                    SYMTAB.put(parts[0], new TableRow(parts[0],LC,SYMTAB.get(parts[0]).getIndex()));
                else
                    SYMTAB.put(parts[0], new TableRow(parts[0],LC,++symIndex));
                    
            }
            
            if(parts[1].equals("DC"))
            {
                parts[2]= parts[2].replace("'","" );
                int constant=Integer.parseInt(parts[2]);
                code="(DL,01) \t (C,"+constant+")";
                bw.write(code+"\n");
                LC=LC+1;
                
            }
             if(parts[1].equals("DS"))
            {
                
                int size=Integer.parseInt(parts[2]);
                code="(DL,02) /t (C,"+size+")";
                bw.write(code+"\n");
                LC=LC+size;
                
            }
             if(lookup.getType(parts[1]).equals("IS"))
             {
                 int j=2;
                 String acode="";
                 code="(IS,0"+ lookup.getCode(parts[1])+")\t";
                 while(j<parts.length)
                 {
                     parts[j]=parts[j].replace(","," ");
                     if(lookup.getType(parts[j]).equals("RG"))
                     {
                         acode=acode+lookup.getCode(parts[j])+"\t";
                     }
                     else
                     {
                         if(SYMTAB.containsKey(parts[j]))
                         {
                             int ind=SYMTAB.get(parts[j]).getIndex();
                             acode=acode+"(S,0"+ind+")";
                         }
                         else
                         {
                            SYMTAB.put(parts[j],new TableRow(parts[j],-1,++symIndex));
                            int ind=SYMTAB.get(parts[j]).getIndex();
                            acode=acode+"(S,0"+ind+")";
                            
                         }
                             
                             
                     }
                     j++;
                 }
                 code=code+acode;
                 bw.write(code+"\n");
                 LC=LC+1;
                 
             }
             printSym();
            
        }
        br.close();
        bw.close();
    }
    
    
    static void printSym() throws Exception
    {
         BufferedWriter b=new BufferedWriter(new FileWriter("/home/d7/sys"));
         java.util.Iterator<String> itr=SYMTAB.keySet().iterator();
         System.out.println("Symbol TABLE");
          while(itr.hasNext())
          {
              String key=itr.next().toString();
              TableRow row = SYMTAB.get(key);
              System.out.println(row.getIndex()+"\t"+row.getsymbol()+"\t"+row.getaddress()+"\n");
              b.write(row.getIndex()+"\t"+row.getsymbol()+"\t"+row.getaddress()+"\n");
              
              
          }
          b.close();
         
    }
}
