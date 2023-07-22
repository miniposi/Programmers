import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        int num; // 이름을 가진 선수의 수
        HashMap<String, Integer> hash = new HashMap<>();
        for (String c : completion) {
            if (hash.containsKey(c))
                num = hash.get(c);
            else
                num = 0;
            hash.put(c, ++num);
        }
        
        for (String p : participant) {
            if (!hash.containsKey(p)) {
                answer += p;
                break;
            }
            num = hash.get(p) - 1;
            if (num == 0)
                hash.remove(p);
            else
                hash.put(p, num);
        }
        
        return answer;
    }
}

/*
participant for 문을 돌면서 completion에 없으면 break, 해당 선수를 answer에 넣음
-> completion만 hashmap에 넣으면 됨
동명이인이 있으므로 hashmap 사용해야함
-> 없었다면 ArrayList를 이용해도됨
*/
