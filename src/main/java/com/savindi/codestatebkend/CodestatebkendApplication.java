package com.savindi.codestatebkend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class CodestatebkendApplication {
    final static String serverUrl1 = "https://gist.githubusercontent.com/PhantomGrin/a1e8ad30915ecd9d2659400d496d1ed6/raw/8b0dbb93521f5d6889502305335104218454c2bf/states_hash.json";

    final static String serverUrl2 = "https://gist.githubusercontent.com/PhantomGrin/a1e8ad30915ecd9d2659400d496d1ed6/raw/8b0dbb93521f5d6889502305335104218454c2bf/states_titlecase.json";

    public static void main(String[] args) {
        SpringApplication.run(CodestatebkendApplication.class, args);
    }

    public static String requestProcessedData(int urlid){
        String serverUrl = null;
        if(urlid == 1){
            serverUrl = serverUrl1;
        }else if (urlid == 2){
            serverUrl = serverUrl2;
        }else{
            return "ERROR";
        }

        RestTemplate request = new RestTemplate();
        String result = request.getForObject(serverUrl, String.class);
        System.out.print(serverUrl);
        return (result);
    }

    @GetMapping("/")
    public static String Hello(){
        return "HELLO IM DATA READER";
    }

    @GetMapping("/readDataForCode")
    public static String requestCodeData(){
        return requestProcessedData(1);
    }

    @GetMapping("/readDataForState")
    public static String requestStateData() {
        return requestProcessedData(2);
    }
}
