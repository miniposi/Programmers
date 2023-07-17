import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // Keypoint! 불린 선수를 찾는 시간을 단축하기 위해 HashMap 사용
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        int cnt = 0;
        for (String player : players) {
            hash.put(player, cnt++);
        }
        
        int idx;
        String prevPlayer;
        // 1. callings 배열을 돌면서 불리는 선수를 하나씩 체크한다
        for(String player : callings) {
            // 2. 불린 선수를 players 배열에서 찾는다
            idx = hash.get(player);
            prevPlayer = players[idx-1];
            hash.put(player, idx-1);
            hash.put(prevPlayer, idx);
            // 3. 찾은 선수와 해당 선수 앞의 선수와 자리를 교환한다
            players[idx-1] = players[idx];
            players[idx] = prevPlayer;
        }

        return players;
    }
}
