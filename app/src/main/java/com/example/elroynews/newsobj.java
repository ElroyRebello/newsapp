package com.example.elroynews;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class newsobj {


    Context context;

    public newsobj(Context context) {
        this.context = context;
    }

    public interface Newsif{
        void onError(String message);

        void onResponse(ArrayList<model> list);
    }
    public void getnews( Newsif newsif)
    {
        String url ="https://saurav.tech/NewsAPI/top-headlines/category/health/in.json";
        ArrayList<model> list = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null
                , response ->{
            // Toast.makeText(context,response.toString(),Toast.LENGTH_SHORT).show();

            try {
                JSONArray article = response.getJSONArray("articles");

                for(int i=0;i<article.length();i++)
                {

                    model m = new model();
                    JSONObject apiobj = (JSONObject) article.get(i);
                    m.setAuthor(apiobj.getString("author"));
                    m.setImageUrl(apiobj.getString("urlToImage"));
                    m.setTitle(apiobj.getString("title"));
                    m.setUrl(apiobj.getString("url"));

                    list.add(m);
                }
                newsif.onResponse(list);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        } , error -> {
            Toast.makeText(context,"wrong",Toast.LENGTH_SHORT).show();
        });
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);

    }

}
