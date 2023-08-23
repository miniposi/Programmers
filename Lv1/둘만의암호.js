function solution(s, skip, index) {
    let answer = '';
    let alphabet = [ 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                   'h', 'i', 'j', 'k',  'l', 'm', 'n', 'o', 'p',
                   'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' ];
    for (let word of skip) {
        let idx = alphabet.indexOf(word);
        alphabet.splice(idx, 1);
    }
    
    let size = alphabet.length;
    for (let word of s) {
        let idx = alphabet.indexOf(word) + index;
        if (idx > size - 1)
            idx %= size;
        answer += alphabet[idx];
    }
    
    return answer;
}
