import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URISyntaxException;

public class Data {

    public String getToken(String xh,String pwd) throws URISyntaxException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder("http://zswxyjw.minghuaetc.com/znlykjdxswxy/app.do");
        uriBuilder.setParameter("method","authUser").setParameter("xh",xh).setParameter("pwd",pwd);
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        CloseableHttpResponse response = httpClient.execute(httpGet);
        String s = null;
        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();
            s = EntityUtils.toString(entity, "utf-8");
        }
        JSONObject obj = new JSONObject();
        obj = obj.fromObject(s);
        Object token = obj.get("token");
        return  token.toString();
    }


}