class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int height = wallpaper.length;
        int width = wallpaper[0].length();
        int minTop = height, minLeft = width;
        int maxBottom = 0, maxRight = 0;
        
        int idx = -1;
        int cntR = 0, cntC = 0;
        for (String row : wallpaper) {
            while (row.indexOf("#", cntC) != -1) {
                idx = row.indexOf("#", cntC);
                if (idx < minLeft)
                    minLeft = idx;
                if (idx > maxRight)
                    maxRight = idx;
                if (cntR < minTop)
                    minTop = cntR;
                if (cntR > maxBottom)
                    maxBottom = cntR;
                cntC = idx + 1;
            }
            cntR++;
            cntC = 0;
        }
        
        answer[0] = minTop;
        answer[1] = minLeft;
        answer[2] = maxBottom + 1;
        answer[3] = maxRight + 1;
        
        return answer;
    }
}
