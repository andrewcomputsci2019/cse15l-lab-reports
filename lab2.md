# Lab 2 - Servers and SSH Keys
___
## String Server
```java
import java.io.IOException;
import java.net.URI;
public class StringServer{
    private class Handler implements URLHandler{
        int num = 1;
        StringBuilder builder = new StringBuilder();
        @Override
        public String handleRequest(URI url) {
            if(url.getPath().contains("add-message")){
                String[] split = url.getQuery().split("=");
                if(!split[0].equals("s")){
                    return "Paramter must be s";
                }
                builder.append(num++ +"."+" "+split[1]+"\n");
                return builder.toString();
            }
            return "404";
        }
    }
    private Handler handler = new Handler();
    public static void main(String[] args) throws IOException{
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }
        int port = Integer.parseInt(args[0]);
        Server.start(port, new StringServer().handler);
    }
}
```
___
### String Server First Request
<!--- image here--->
* The Method called in my code is the `handleRequest` method found inside of my `Handler` class
* There is one relevant argument to my method that being the URI url argument, containing the url `/add-message?s=hello%20world`, passed into the method. There are two class fields that are revenant to this method those being `int num` and `StringBuilder builder`. Their values respectfully are `1` and `""` (empty string).
* The two fields are changed during the execution of this method, The first being the `builder` field which is mutated such that the `num` field and the string from the url query parameter are append onto `builder`. In this example `builder` changes from `""` to `"1. hello world\n"`. `num` also changes as it is incremented in the method, meaning `num` changes from `1` to `2`
___
### String Server Second Request