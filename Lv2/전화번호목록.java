import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        int max = 1;
        HashSet<String> hash = new HashSet<>();
        for (String phone : phone_book) {
            hash.add(phone);
        }
        
        boolean flag = false;
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (hash.contains(phone.substring(0, i))) {
                    answer = false;
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }
        
        return answer;
    }
}
