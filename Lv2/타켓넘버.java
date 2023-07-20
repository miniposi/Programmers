class Solution {
    private int size; // numbers의 수
    private int targetNum; // target 전역변수로 설정
    private int count = 0; // target이 나오는 경우의 수
    private int numberArray[]; // numbers 배열 전역변수로 설정
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        size = numbers.length;
        numberArray = numbers;
        targetNum = target;
        
        GetAnswer(0, 0, 1); // 첫번째 인덱스를 더하는 경우
        GetAnswer(0, 0, -1); // 첫번째 인덱스를 뺴는 경우
        
        answer = count; // answer 업데이트
        
        return answer; // 사실 바로 count를 return 해도 됨
    }
    
    void GetAnswer(int idx, int sum, int flag) {
        // flag를 통해 더할 것인지, 뺄 것인지 여부를 확인
				sum += numberArray[idx] * flag;
				
        // 마지막 인덱스라면 sum을 target과 비교한 후 return
        if (idx == size - 1) {
            if (sum == targetNum)
                count++;
            return;
        }
        
				// 다음 인덱스를 더하는 경우
        GetAnswer(idx+1, sum, 1);
				// 다음 인덱스를 빼는 경우
        GetAnswer(idx+1, sum, -1);
    }
}
