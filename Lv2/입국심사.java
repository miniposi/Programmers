class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int size = times.length;
        
        long maxTime = 0;
        for (int i = 0; i < size; i++) {
            if (times[i] > maxTime)
                maxTime = times[i];
        }
        
        long left = 0; // 최소 시간
        long right = maxTime * n; // 최대 시간
        long mid;
        long avaNum;
        while (left <= right) {
            mid = (left + right) / 2;
            avaNum = 0;
            for (int i = 0; i < size; i++) {
                avaNum += mid / times[i];
            }
            if (avaNum < n) // 해당 시간에 n명보다 적게 받을 수 있음
                left = mid + 1;
            else {
                right = mid - 1;
                answer = mid; // n명 받을 수 있지만 while문을 더 돌면서 줄일 수 있는 지 체크
            }
        }
        
        return answer;
    }
}
