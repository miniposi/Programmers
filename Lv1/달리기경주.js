const solution = (players, callings) => {
  let map = new Map();
  for (let i = 0; i < players.length; i++) {
    map.set(players[i], i);
  }
  callings.forEach((c) => {
      let idx = map.get(c);
      map.set(players[idx-1], idx);
      map.set(players[idx], idx-1);
      [players[idx], players[idx-1]] = [players[idx-1], players[idx]];
  });
    
  return players;
}
