class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxW = 1, maxH = 1;
        
        int size = sizes.length;
        int w, h;
        for (int i = 0; i < size; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                w = sizes[i][0];
                h = sizes[i][1];
            }
            else {
                w = sizes[i][1];
                h = sizes[i][0];
            }
            
            if (w > maxW)
                maxW = w;
            if (h > maxH)
                maxH = h;
        }
        answer = maxW * maxH;
        
        return answer;
    }
}
