package commm.example.iteradmin.currentweatherreport

import android.app.DownloadManager
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.textclassifier.TextLinks
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val b = findViewById<Button>(R.id.save)
        val e = findViewById<EditText>(R.id.city)
        val t = findViewById<TextView>(R.id.report)
        val queue = Volley.newRequestQueue(this)
        val url:String = "https://api.openweathermap.org/data/2.5/weather?q="
        val api:String="&appid=785b901a8c11590506be8f6396fc0469"
        b.setOnClickListener {
            val complink = url+e.text.toString()+api

            val jsnRequest:JsonObjectRequest= JsonObjectRequest(Request.Method.GET,complink,null,
            Response.Listener <JSONObject>{
                response ->
                val ar:JSONObject=response.getJSONObject("coord")
                val str:String="Longitude:"+ar.get("lon")+"Latitude:"+ar.get("lat")
                t.text= str
                //Toast.makeText(this,response.substring(20,30),Toast.LENGTH_LONG).show()
            },
            Response.ErrorListener {
             //   Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
            } )
            queue.add(jsnRequest)

        }

    }
}
