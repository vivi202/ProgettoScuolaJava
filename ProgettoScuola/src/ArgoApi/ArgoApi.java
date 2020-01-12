package ArgoApi;


import ArgoApi.Eccezioni.AccessoNonRiuscito;
import ArgoApi.Eccezioni.AccessoNonEffettuato;
import ArgoApi.Modelli.ListaVoti;
import ArgoApi.Modelli.Voto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;
/*Jso
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vincenzo
 */
public class ArgoApi {
    private final String endPoint="https://www.portaleargo.it/famiglia/api/rest/";//indirizzo api Rest portaleArgo
    
    private String authToken;//token di autorizzazione utente
    
    private final String chiaveArgo="ax6542sdru3217t4eesd9";//chiave rest
    
    private final String versioneArgo="2.1.0";
    
    private final String produttore="ARGO Software s.r.l. - Ragusa";
    
    private final String codiceApp="APF";
    
    private final String uA="Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36";
    
    private final String codiceScuola; //codice della scuola
    
    private final String username;
    
    private final String password;
    
    private boolean loggedIn=false; //indica se l'accesso è stato eseguito
    
    //variabili necessare per poter fare richieste all'api
    private int prgAlunno;
    
    private int prgScuola;
    
    private int prgScheda;
    //-------------------------------------------------------------------------
    
    public ArgoApi(String codiceScuola, String username, String password) {
        
        this.codiceScuola = new String(codiceScuola);
        
        this.username = new String(username);
        
        this.password = new String(password);
    }

    public void accedi() throws IOException, AccessoNonRiuscito{
        /*
            metodo per accedere e effettuare la richiesta del token utente 
        */
        try {
            BufferedReader reader;
            String line;
            StringBuilder resp=new StringBuilder();
            URL Login=new URL(this.endPoint+"login");
            HttpURLConnection con=(HttpURLConnection) Login.openConnection();
            
            //setup header
            con.setRequestMethod("GET");
            
            con.setRequestProperty("x-key-app", chiaveArgo);
            
            con.setRequestProperty("x-version", versioneArgo);
            
            con.setRequestProperty("x-produttore-software", produttore);
            
            con.setRequestProperty("x-app-code", codiceApp);
            
            con.setRequestProperty("x-cod-min", codiceScuola);
            
            con.setRequestProperty("x-user-id", username);
            
            con.setRequestProperty("x-pwd", password);
            
            con.setRequestProperty("User-Agent", uA); 
            //---------------------------------------------------
            int status=con.getResponseCode();//stato della response
            
            if(status>299){//c'è stato un errore
                reader= new BufferedReader(new InputStreamReader(con.getErrorStream()));//inizializzo il buffer
                
                while((line=reader.readLine())!= null){//leggo il body della response  
                    resp.append(line);                          
                }
                
                reader.close();//chiudo il buffer
                System.err.println(resp.toString());
                throw new AccessoNonRiuscito();
            }else{//la richiesta è avvenuta con successo
                
                reader= new BufferedReader(new InputStreamReader(con.getInputStream()));//inizializzo il buffer
                
                while((line=reader.readLine())!= null){//leggo il body della response
                    resp.append(line);  
                }
                
                reader.close();
                
                JSONObject response=new JSONObject(resp.toString());//creo oggetto json dalla response
                
                this.authToken=response.getString("token");
                
                this.loggedIn=true;
                
                this.getSchede();//recupero la scheda utente da argo
            }
        } catch (MalformedURLException ex) {
             Logger.getLogger(ArgoApi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessoNonEffettuato ex) {
            Logger.getLogger(ArgoApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
      private void getSchede() throws IOException,AccessoNonEffettuato{
          //metodo per richiedere la scheda utente da argo
        if(loggedIn){
            try {
                BufferedReader reader;
                String line;
                StringBuilder resp=new StringBuilder();
                URL Login=new URL(this.endPoint+"schede");
                HttpURLConnection con=(HttpURLConnection) Login.openConnection();
            
                //setup header
                con.setRequestMethod("GET");
                con.setRequestProperty("x-key-app", chiaveArgo);
                con.setRequestProperty("x-version", versioneArgo);
                con.setRequestProperty("x-produttore-software", produttore);
                con.setRequestProperty("x-app-code", codiceApp);
                con.setRequestProperty("x-cod-min", codiceScuola);
                con.setRequestProperty("x-auth-token", authToken);
                con.setRequestProperty("User-Agent", uA);  
                //-------------------------------------------------------------
                
                int status=con.getResponseCode();
                if(status>299){//c'è stato un errore
                    reader= new BufferedReader(new InputStreamReader(con.getErrorStream()));//inizializzo il buffer
                    
                    while((line=reader.readLine())!= null){
                        resp.append(line);
                    }
                    
                    reader.close();
                    System.err.println(resp.toString());
                }else{//la richiesta è avvenuta con successo
                    reader= new BufferedReader(new InputStreamReader(con.getInputStream()));//
                    while((line=reader.readLine())!= null){
                        resp.append(line);
                    }
                    reader.close();
                    JSONArray scheda;
                    scheda=new JSONArray(resp.toString());
                    this.prgAlunno=scheda.getJSONObject(0).getInt("prgAlunno");
                    this.prgScheda=scheda.getJSONObject(0).getInt("prgScheda");
                    this.prgScuola=scheda.getJSONObject(0).getInt("prgScuola");
                }   
            } catch (MalformedURLException ex) {
                System.out.println("er");
            }
        }else{
            throw new AccessoNonEffettuato();
        }
    }
    
    public ListaVoti getVoti() throws IOException, AccessoNonEffettuato{
        if(loggedIn){
            try {
                BufferedReader reader;
                String line;
                StringBuilder resp=new StringBuilder();
                URL Login=new URL(this.endPoint+"votigiornalieri");
                HttpURLConnection con=(HttpURLConnection) Login.openConnection();
            
                //setup header
                con.setRequestMethod("GET");
                con.setRequestProperty("x-key-app", chiaveArgo);
                con.setRequestProperty("x-version", versioneArgo);
                con.setRequestProperty("x-produttore-software", produttore);
                con.setRequestProperty("x-app-code", codiceApp);
                con.setRequestProperty("x-cod-min", codiceScuola);
                con.setRequestProperty("x-auth-token", authToken);
                con.setRequestProperty("x-prg-alunno",Integer.toString(prgAlunno));
                con.setRequestProperty("x-prg-scheda",Integer.toString(prgScheda));
                con.setRequestProperty("x-prg-scuola",Integer.toString(prgScuola));
                con.setRequestProperty("x-auth-token", authToken);
                con.setRequestProperty("User-Agent", uA);  
                //----------------------------------------------------------------
                
                int status=con.getResponseCode();
                
                if(status>299){
                    reader= new BufferedReader(new InputStreamReader(con.getErrorStream()));
                    
                    while((line=reader.readLine())!= null){
                        resp.append(line);
                    }
                    reader.close();
                    System.err.println(resp.toString());
                    
                }else{
                    reader= new BufferedReader(new InputStreamReader(con.getInputStream()));
                    while((line=reader.readLine())!= null){
                        resp.append(line);
                    }
                    reader.close();
                    JSONArray votiJSON;
                    votiJSON=new JSONObject(resp.toString()).getJSONArray("dati");
                    ListaVoti voti=new ListaVoti();
                    for(int i=0;i<votiJSON.length();i++){
                        JSONObject voto=votiJSON.getJSONObject(i);
                        
                        try{
                        Voto v=new Voto(voto.getString("desMateria"),voto.getDouble("decValore"), voto.getString("datGiorno"));//creo oggetto voto
                        voti.insCoda(v);//inserisco il voto nella lista
                        
                        }catch(JSONException e){
                            
                        }
                    }
                    return voti;
                }   
            } catch (MalformedURLException ex) {
                Logger.getLogger(ArgoApi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            throw new AccessoNonEffettuato();
        }
        return null;
    }
}
