import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class RequestQueue {

    String url = "http://httpbin.org/html";

    // Request a string response
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    // Result handling
                    System.out.println(response.substring(0, 100));

                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

            // Error handling
            System.out.println("Something went wrong!");
            error.printStackTrace();

        }
    });
}
