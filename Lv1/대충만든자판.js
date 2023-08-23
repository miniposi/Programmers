function solution(keymap, targets) {
    let answer = [];
    for (let target of targets) {
        let sum = 0;
        for (let word of target) {
            let minPos = 101; // 최대 keymap + 1
            for (let key of keymap) {
                if (!key.includes(word))
                    continue;
                if (key.indexOf(word) + 1 < minPos)
                    minPos = key.indexOf(word) + 1;
            }
            if (minPos === 101) {
                sum = -1;
                break;
            }
            else
                sum += minPos;
        }
        answer.push(sum);
    }
    
    return answer;
}
