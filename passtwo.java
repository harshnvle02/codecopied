package passTwoAssembler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class passtwo {
	public static void main(String args[]) throws IOException {
		BufferedReader br1 = new BufferedReader(new FileReader("C:/Users/DELL/OneDrive/Desktop/symtab"));
		String line;
		ArrayList<TableRow> symtab = new ArrayList<>();
		
		while((line = br1.readLine()) != null) {
			String parts[] = line.split("\\s+");
			symtab.add(new TableRow(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[0])));
			
		}
		br1.close();
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/DELL/OneDrive/Desktop/Intermediate"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/DELL/OneDrive/Desktop/MachineCode"));

		while((line = br.readLine()) != null) {
			String parts[] = line.split("\\s+");
			if(parts[0].contains("AD")||parts[0].contains("(DL,02)")) {
				bw.write("\n");
			}
			else if(parts[0].contains("DL,01")) {
				String[] opcode = parts[1].split(",");
				opcode[1] = opcode[1].replace(")", "");
				bw.write("+ 00 0  00"+opcode[1] + "\n");
			}
			else if(parts[0].contains("IS")) {
				if(parts.length == 1) {
					String[] opcode = parts[0].split(",");
					opcode[1] = opcode[1].replace(")", "");
					bw.write("+ 00 0  0" + opcode[1] + "\n");
				}
				else {
					String op= "+ ";
					String[] opcode = parts[0].split(",");
					opcode[1] = opcode[1].replace(")", "");
					op = op + opcode[1] + " ";
					
					if(parts.length == 2) {
						String[] opc = parts[1].split(",");
						opc[1] = opc[1].replace(")", "");
						int oc = Integer.parseInt(opc[1]);
						int add = symtab.get(oc-1).getAddress();
						
						op = op + add + " ";
					}
					else if(parts.length == 3) {
						String[] rg = parts[1].split(",");
						rg[1] = rg[1].replace(")", "");
						op = op + rg[1] + " ";
						
						String[] opc = parts[2].split(",");
						opc[1] = opc[1].replace(")", "");
						int oc = Integer.parseInt(opc[1]);
						int add = symtab.get(oc-1).getAddress();
						
						op = op + add + " ";
					}
					
					bw.write(op + "\n");
				}
				
			}
		}
		bw.close();
		br.close();
		System.out.println("DONE!!");
		
	}
}
