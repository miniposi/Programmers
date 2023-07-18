import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for (String term : terms) {
            hash.put(String.valueOf(term.charAt(0)), Integer.parseInt(term.substring(2)));
        }
        
        String[] todayString = today.split("\\.");
        int todayDate = Integer.parseInt(todayString[0]) * 12 * 28 + Integer.parseInt(todayString[1]) * 28
            + Integer.parseInt(todayString[2]);
        
        int T, cnt = 1;
        boolean flag = false;
        for (String privacy : privacies) {
            String[] str = privacy.split(" ");
            T = hash.get(str[1]);
            
            String[] temp = str[0].split("\\.");
            int expDate = Integer.parseInt(temp[0]) * 12 * 28 + Integer.parseInt(temp[1]) * 28 + Integer.parseInt(temp[2]);
            expDate += T * 28;
            
            if (todayDate >= expDate) {
                // answer에 담기
                answerList.add(cnt);
            }
            
            cnt++;
        }
        
        return answerList;
    }
}
