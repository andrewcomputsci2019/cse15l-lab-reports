import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Main{
    public static void main(String args[]){ 
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        int indexer = 0;
        for(String ele: args){
            String[] spliter = ele.split(",");
            for(String subEle: spliter){
                if(indexer%2 == 0){
                    a.add(Integer.parseInt(subEle));
                }else{
                    b.add(Integer.parseInt(subEle));
                }
            }
            indexer++;
        }
        System.out.println(Main.merge(a,b));
    }
    public static List<Integer> merge(List<Integer> a, List<Integer> b){
        List<Integer> ans = new ArrayList<Integer>();
        int indexA = 0;
        int indexB = 0;
        while(indexA < a.size() && indexB < b.size()){
            int val = a.get(indexA) < b.get(indexB) ? a.get(indexA++) : b.get(indexB++);
            ans.add(val);
        }
        while(indexA < a.size()){
            ans.add(a.get(indexA));
        }
        while(indexB < b.size()){
            ans.add(a.get(indexB++));
        }
        return ans;
    }
}
