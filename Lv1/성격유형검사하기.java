import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        hash.put("R", 0); hash.put("T", 0); hash.put("C", 0); hash.put("F", 0);
        hash.put("J", 0); hash.put("M", 0); hash.put("A", 0); hash.put("N", 0); 
        
        for (int i = 0; i < choices.length; i++) {
            String index;
            int num;
            if (choices[i] > 4) {
                index = survey[i].substring(1);
                num = hash.get(index) + (choices[i] - 4);
                hash.put(index, num);
            } else {
                index = survey[i].substring(0, 1);
                num = hash.get(index) + (4 - choices[i]);
                hash.put(index, num);
            }
        }
        
        if (hash.get("R") >= hash.get("T"))
            answer += "R";
        else
            answer += "T";
        if (hash.get("C") >= hash.get("F"))
            answer += "C";
        else
            answer += "F";
        if (hash.get("J") >= hash.get("M"))
            answer += "J";
        else
            answer += "M";
        if (hash.get("A") >= hash.get("N"))
            answer += "A";
        else
            answer += "N";
        
        return answer;
    }
}
