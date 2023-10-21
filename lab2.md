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
                    return "Parameter must be s";
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
* There is one relevant argument to my method that being the URI url argument, containing the url `/add-message?s=hello%20world`, passed into the method. There are two class fields that are revenant to this method. Those being `int num` and `StringBuilder builder`. Their values respectfully are `1` and `""` (empty string) when the method is called.
* The two fields are changed during the execution of this method, The first being the `builder` field which is mutated such that the `num` field and the string from the url query parameter are append onto `builder`. In this example `builder` changes from `""` to `"1. hello world\n"`. `num` also changes as it is incremented in the method, meaning `num` changes from `1` to `2`
___
### String Server Second Request
<!--- image here--->
* Same as the first example the method called in my called is the `handleRequest` method in my `Handler` class
* Still there is only one relevant argument to my method that being the URI url argument,which has the the url value of `"/add-message?s=good%20bye%20world"`. There are still the two same class field relevant to my method, those being `builder` and `num`. Before and during the start of the method call the fields have the values of `"1. hello world\n"` and `2` respectfully. After the method call `builder` is appended with `2. good bye world\n` and `num` is incremented to `3`.
___
## Part 2 - SSH keys

___


The first thing a learned from weeks 2 and 3 was ssh config files which are really cool and allow me to specify what private keys correspond to different hosts with out me memory where each keys exist on my filesystem. The second thing I learned from weeks 2 and 3 was java in built http provider, I have always used the spring framework to create web-servers in java, so it was interesting to learn and see the differences within java in built style/method.