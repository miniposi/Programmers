function solution(cards1, cards2, goal) {
    let answer = '';
    for (let word of goal) {
        if (cards1[0] === word) {
            cards1.shift();
            continue;
        }
        if (cards2[0] === word) {
            cards2.shift();
            continue;
        }
        answer += 'No';
        return answer;
    }
    answer += 'Yes';
    
    return answer;
}

/*
goal 배열을 돌면서,
card1과 card2의 맨 앞 단어로 goal을 구성할 수 있는 지 확인
구성하게 되는 단어는 card에서 제외
*/
