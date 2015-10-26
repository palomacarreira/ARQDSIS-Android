package br.usjt.cursoandroid2015.aeronaveprojeto;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;


/**
 * Created by palomacarreira on 07/09/15.
 */
public class ListaPassagemActivity extends ActionBarActivity {

    public String getJSON(String address){
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(address);
        try{
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if(statusCode == 200){
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while((line = reader.readLine()) != null){
                    builder.append(line);
                }
            } else {
                Log.e(MainActivity.class.toString(),"Failedet JSON object");
            }
        }catch(ClientProtocolException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_passagem);

        Selecao selecao = new Selecao();
        //pega a mensagem do intent
        Intent intent = getIntent();
        String origem = intent.getStringExtra(MainActivity.ORIGEM);
        String destino = intent.getStringExtra(MainActivity.DESTINO);

        TreeSet<Passagem> lista = selecao.listarTodasPassagens(origem, destino);

        //cria o texto da view
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {
            //ALTERAR COM O IP DA MAQUINA UTILIZADA
            String url =   "http://192.168.0.100:8080/Projeto_Web_ARQDSIS/PesquisarPassagemJson?origem="+origem+"&destino="+destino;

            String json = getJSON(url);
            Log.d("AQUI!",json);

            JSONArray array = new JSONArray(json);

            TextView textView = (TextView) findViewById(R.id.txt_lista_passagem);
            String message = "";

            for(int i = 0; i < array.length(); i++){
                JSONObject jobject = (JSONObject) array.get(i);


                message += jobject.getString("origem") + "-" + jobject.getString("destino") + "-" + jobject.getString("horaPartida") + "-" + jobject.getDouble("valor") + "\n";


            }
            if(message.length() == 0) {
                message = "Nenhuma passagem encontrada para o critério escolhido.";
                textView.setLines(3);
            } else {
                textView.setLines(array.length());
            }
            textView.setText(message);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
