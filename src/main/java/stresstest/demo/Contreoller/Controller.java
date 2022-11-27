package stresstest.demo.Contreoller;





import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import stresstest.demo.Auxiliary;
import stresstest.demo.Model.Monster;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import java.util.stream.Stream;

@RestController
public class Controller {

// private static Logger logger = LogManager.getLogger(Controller.class);

    private static Logger logger = LogManager.getLogger(Controller.class);

//    Logger logger = LoggerFactory.getLogger(Controller.class);


//    Logger logger =
    @GetMapping("/monstrum")
    @ResponseBody
    public void monstrum(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) Integer monsterStrength,
            @RequestParam(required = false) Integer eyes,
            @RequestParam(required = false) Integer noses,
            @RequestParam(required = false) Integer paws,
            @RequestParam(required = false) Boolean isFlying

    ) {

        Auxiliary auxiliary = new Auxiliary();
        Monster newMonster = auxiliary.monsterGeneration(name, Optional.ofNullable(eyes)
                , Optional.ofNullable(noses)
                , Optional.ofNullable(paws)
                , Optional.ofNullable(isFlying)
        );
        auxiliary.attack(monsterStrength);
    }

    public void monstrum_(
            int monsterStrength,
            String name,
            Optional<Integer> eyes,
            Optional<Integer> noses,
            Optional<Integer> paws,
            Optional<Boolean> isFlying
    ) {
        Auxiliary auxiliary = new Auxiliary();
        Monster newMonster = auxiliary.monsterGeneration(name, eyes
                , noses
                , paws
                , isFlying
        );
        auxiliary.attack(monsterStrength);
    }
    @GetMapping("/greeting")
    public ResponseEntity<String> greeting(@RequestHeader("accept-language") String language) {
        // code that uses the language variable
        String greeting="aa";
        return new ResponseEntity<String>(greeting, HttpStatus.OK);
    }

    @GetMapping("/err-loop-str")
    @ResponseBody
    public void getErrLoopStr() {
        int a = 0;
        String b="amamamamamamamaamamaamamamamamammamamamamamamamamamama";
        b=b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b;
        for (int i = 0; i < 1000; i++) {
            b= b+b;
            a = 0;
        }
        a = a / a;
    }

    @GetMapping("/")
    @ResponseBody
    public void getSuc() {
        logger.error("An ERROR Message");
        logger.trace("An INFO Message");
        monstrum_(0, "www", Optional.ofNullable(2), Optional.ofNullable(2), Optional.ofNullable(2), Optional.ofNullable(true));
    }

    @GetMapping("/err")
    @ResponseBody
    public void getErr() {
        monstrum_(100000, "www", Optional.ofNullable(22), Optional.ofNullable(23), Optional.ofNullable(22), Optional.ofNullable(false));
    }


    @GetMapping("/err-loop")
    @ResponseBody
    public void getErrLoop() {
        int a = 0;
        for (int i = 0; i < 1000; i++) {
            a = 0;
        }
        a = a / a;
    }

    @GetMapping("/multi-err")
    @ResponseBody
    public String multiErr() throws IOException {

     String host =System.getenv("HOST_MULTI");
        String url = "http://"+host+"/err";

        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getForEntity(url, String.class).getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    @GetMapping("/multi")
    @ResponseBody
    public String multi() throws IOException {

        String host =System.getenv("HOST_MULTI");
        String url = "http://"+host+"/";

        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getForEntity(url, String.class).getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    @GetMapping("/err-short")
    @ResponseBody
    public void getErrShort() {
        int a=0;
        a=a/a;
    }
    @GetMapping("/short")
    @ResponseBody
    public void getShort() {


    }
    @GetMapping("/aaa")
    @ResponseBody
    public String g() {

        is();
        no();
        go();
        build();
        find();
        drop();
        git();
        none();
        date(1);
        next();
        in();
        on();
        off();
        play();
        start();
        stop();
        revdebug();
        bin();
        rdb0c899cd236704b3eacef56fbde4a312c();
        java();
        maven();
        gradle();applicationId();
        sw();
        org();
        com();
        rdbshaded();
        parser();
        return "a";
    }

//   public String is(){
//      return "a";
//   }applicationId
void is(){      int a=0;
    a=a/a;}
public void  REVDEBUG_EXCLUDE(){}
    public void  SourceVersion(){}
    public void  http(){}
    public void  org(){
        int b=2;
        b=b+b+b;

        int a=0;

    }


    public void  com(){}
    public void  rdbshaded(){}
    public void  parser(){}

    void sw(){}
public void  applicationId(){}
    public void  gradle(){}
    public void  maven(){}
    public void  rdb0c899cd236704b3eacef56fbde4a312c(){}
    public void  java(){}
public String revdebug(){

    return "";
}
    public String bin(){

        return "";
    }
public String start(){
    int is=0;
    return "";
}
    public String stop(){
        int is=0;
        return "";
    }
public String play(){
    int is=0;
    return "";
}
    public String next(){
        int is=0;
        return "";
    }
    public  void date(int is){

    }

    public void none(){

    }
    public void git(){

    }
    public String drop(){
        return "a";
    }
    public void find(){

    }
    public String build(){
        return "a";
    }

    public String no(){
        return "a";
    }
    public String go(){
        return "a";
    }
    public String in(){
        return "a";
    }
    public String on(){
        return "a";
    }
    public String off(){
        return "a";
    }

    @GetMapping("/log")
    @ResponseBody
    public void getShortLogging() {
//        logger.info("Nanana");
////        logger.trace("A TRACE Message");
////        logger.debug("A DEBUG Message");
////        logger.info("An INFO Message");
////        logger.warn("A WARN Message");
//      logger.error("An ERROR Message");

//        logger.debug("Debug log message");
    }
    public String givenJava_whenUsingSystemProp_thenGetVersion() {
        String[] versionElements = System.getProperty("java.version").split("\\.");
        int discard = Integer.parseInt(versionElements[0]);
        int version;
        if (discard == 1) {
            version = Integer.parseInt(versionElements[1]);
        } else {
            version = discard;
        }
        return String.valueOf(version) ;
    }

//    @GetMapping("versions")
//    public String java(){
//        List<String> list =new ArrayList<String>();
//        String rdbV="";
//        try{        Stream.of(RevDeBug.Storage.class)
//                .map(VersionExtractor::extractVersion)
//                .forEach(list::add);}catch(Exception e){}
//
//
//        for (String i:list) {
//            rdbV+=i;
//        }
//        return "Java version: "+ givenJava_whenUsingSystemProp_thenGetVersion()+ "<br/> RevDeBug version:"+ rdbV;
//    }





    @GetMapping("/loop")
    @ResponseBody
    public void getLoop() {
        int a=0;
        for (int i=0;i<1000; i++){
        a=0;
        }
    }

}
