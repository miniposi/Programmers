class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int height = park.length;
        int width = park[0].length();
        
        // 1. 시작 지점 찾기
        for (int i = 0; i < height; i++) {
            if (!park[i].contains("S"))
                continue;
            answer[0] = i;
            answer[1] = park[i].indexOf("S");
            break;
        }
        
        // 2. routes 배열을 돌면서, [op n]이 이동 가능한 지 확인
        int x, y; // 이동할 좌표
        boolean flag = false; // 이동 가능 여부 - flag 가 true면 이동 불가
        for (String route : routes) {
            flag = true;
            x = answer[0];
            y = answer[1];
            
            switch (route.charAt(0)) {
                case 'N':
                    x = answer[0] + (-1 * (route.charAt(2) - '0'));
                    // x가 0과 height 사이에 있는지 확인
                    if (x >= 0) {
                        flag = false;
                        for (int i = answer[0]; i >= x; i--) // 현재 위치(answer[0])와 도달할 위치(x) 사이에 X가 존재하는지 확인
                        {
                            if (park[i].charAt(y) == 'X') {
                                flag = true;
                                break;
                            }
                        }
                    }
                    break;
                case 'S':
                    x = answer[0] + 1 * (route.charAt(2) - '0');
                    // x가 0과 height 사이에 있는지 확인
                    if (x < height) {
                        flag = false;
                        for (int i = answer[0]; i <= x; i++) // 현재 위치(answer[0])와 도달할 위치(x) 사이에 X가 존재하는지 확인
                        {
                            if (park[i].charAt(y) == 'X') {
                                flag = true;
                                break;
                            }
                        }
                    }
                    break;
                case 'W':
                    y = answer[1] + (-1 * (route.charAt(2) - '0'));
                    // y가 0과 width 사이에 있는지 확인
                    if (y >= 0) {
                        flag = false;
                        // 현재 위치(answer[0])와 도달할 위치(y) 사이에 X가 존재하는지 확인
                        if (park[x].indexOf("X", y) >= y && park[x].indexOf("X", y) <= answer[1]) {
                            flag = true;
                        }
                    }
                    break;
                case 'E':
                    y = answer[1] + 1 * (route.charAt(2) - '0');
                    // y가 0과 width 사이에 있는지 확인
                    if ((y < width)) {
                        flag = false;
                        // 현재 위치(answer[0])와 도달할 위치(y) 사이에 X가 존재하는지 확인
                        if (park[x].indexOf("X", answer[1]) >= answer[1] && park[x].indexOf("X", answer[1]) <= y) {
                            flag = true;
                        }
                    }
                    break;
            }
            
            if (flag)
                continue;
            answer[0] = x;
            answer[1] = y;
        }
        
        return answer;
    }
}
