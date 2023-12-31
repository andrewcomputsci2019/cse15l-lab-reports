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
![screenshot 1](https://github.com/andrewcomputsci2019/cse15l-lab-reports/assets/54915639/b403436a-d768-4c65-a4f4-4ae2b0b15e44)
* The Method called in my code is the `handleRequest` method found inside of my `Handler` class
* There is one relevant argument to my method that being the URI url argument, containing the url `/add-message?s=hello%20world`, passed into the method. There are two class fields that are relevant to this method. Those being `int num` and `StringBuilder builder`. Their values respectfully are `1` and `""` (empty string) when the method is called
* The two fields are changed during the execution of this method, The first being the `builder` field which is mutated such that the `num` field and the string from the url query parameter are append onto `builder`. In this example `builder` changes from `""` to `1. hello world\n`. `num` also changes as it is incremented in the method, meaning `num` changes from `1` to `2`

___

### String Server Second Request
<!--- image here--->
![screenshot 2](https://github.com/andrewcomputsci2019/cse15l-lab-reports/assets/54915639/86c7ebaa-c4ab-4754-80b9-12cc88782982)

* Same as the first example the method called in my called is the `handleRequest` method in my `Handler` class
* Still there is only one relevant argument to my method that being the URI url argument, which has the the url value of `/add-message?s=good%20bye%20world`. There are still the two same class fields relevant to my method, those being `builder` and `num`. Before and during the start of the method call the fields have the values of `1. hello world\n` and `2` respectfully
* After the method call `builder` is appended with `2. good bye world\n` and `num` is incremented to `3` .  `builder` final value is `1. hello world\n2. good bye world\n`

___

## Part 2 - SSH keys
![](https://github.com/andrewcomputsci2019/cse15l-lab-reports/assets/54915639/3a9f61b9-61af-49d3-b99c-d9a830e33994)
![](https://github.com/andrewcomputsci2019/cse15l-lab-reports/assets/54915639/36623f4b-a176-4de3-8757-b7eeb26a53f4)
![](https://github.com/andrewcomputsci2019/cse15l-lab-reports/assets/54915639/b2ef5fbd-ac71-4c48-8629-2866d3f12811)

---
## What I have learned from weeks 2 & 3
The first thing I learned from weeks 2 and 3 was SSH config files which are really cool and allowed me to specify what private keys correspond to different hosts and what users to use on those different hosts. This ultimately lets me just type the hostname of the SSH server I want to connect to and it will use the config file to figure everything out for me, super cool. The second thing I learned from weeks 2 and 3 was Java's in-built http provider, I have always used the Spring framework to create web servers in Java, so it was interesting to learn and see the differences within Java's built-in style/method.

