/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changeprone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author aryan_000
 */
public class LOC {
   public static int getLines(File f) throws IOException { 
FileReader fr=new FileReader(f);
BufferedReader br=new BufferedReader(fr); 
int i=0;
boolean isEOF=false;
do{
String t=br.readLine();
if(t!=null){
isEOF=true;
t=t.replaceAll("\\n|\\t|\\s", "");
if((!t.equals("")) && (!t.startsWith("//"))) {
i = i + 1;
}
}
else {
isEOF=false;
}
}while(isEOF);
br.close();
fr.close();
return i;
}
}
