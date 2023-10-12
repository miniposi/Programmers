function solution(t, p) {
    let answer = 0;
    let sizeT = t.length;
    let sizeP = p.length;
    let intP = parseInt(p);
    for (let i = 0; i <= sizeT - sizeP; i++) {
        let subT = +t.substring(i, i + sizeP);
        if (subT <= intP)
            answer++;
    }
    
    return answer;
}
