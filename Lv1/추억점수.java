import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        // 1. name과 yearing을 HashMap에 담기
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for (int i = 0; i < yearning.length; i++) {
            hash.put(name[i], yearning[i]);
        }
        
        // 2. photo 배열을 돌면서
        int sum, cnt = 0;
        for (String[] eachPhoto : photo) {
            sum = 0;
            // 2-1. 각 name에 해당하는 yearing을 찾아 sum 변수에 더함
            for (String eachName : eachPhoto) {
                if (hash.containsKey(eachName))
                    sum += hash.get(eachName);
            }
            // 2-2. sum 변수의 값을 answer의 배열에 담기
            answer[cnt++] = sum;
        }
        
        return answer;
    }
}
