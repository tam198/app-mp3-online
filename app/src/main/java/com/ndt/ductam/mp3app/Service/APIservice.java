package com.ndt.ductam.mp3app.Service;

public class APIservice {
    private static String base_url = "https://mp3-app.000webhostapp.com/Server/";

    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
