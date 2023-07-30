import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public Integer[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<Integer>();
        
        int size = answers.length;
        int[] first = { 1, 2, 3, 4, 5 }; // 5
        int[] second = { 2, 1, 2, 3, 2, 4, 2, 5 }; // 8
        int[] third = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // 10
        int[] cnt = { 0, 0, 0 };
        for (int i = 0; i < size; i++) {
            if (first[i%5] == answers[i])
                cnt[0]++;
            if (second[i%8] == answers[i])
                cnt[1]++;
            if (third[i%10] == answers[i])
                cnt[2]++;
        }
        
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        for (int i = 0; i < 3; i++) {
            if (cnt[i] == max)
                answer.add(i+1);
        }
        
        //return answer.stream().mapToInt(Integer::intValue).toArray();
        return answer.toArray(new Integer[answer.size()]);
    }
}

/*
12345
21232425
3311224455
*/
