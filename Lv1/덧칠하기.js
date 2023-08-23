function solution(n, m, section) {
    let answer = 0;
    
    let lastItem = section[section.length - 1];
    let position = section[0];
    while (position < n + 1) {
        if (!section.includes(position)) {
            position++;
            continue;
        }
        
        position += m;
        answer++;
        if (position > lastItem)
            break;
    }
    
    return answer;
}
