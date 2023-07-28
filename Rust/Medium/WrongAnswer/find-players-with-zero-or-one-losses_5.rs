impl Solution {
    pub fn find_winners(matches: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut players = vec![0; 100001];
        let mut winners = vec![];
        let mut losers = vec![];
        for m in matches {
            players[m[0] as usize] += 1;
            players[m[1] as usize] -= 1;
        }
        for i in 1..players.len() {
            if players[i] == 0 {
                winners.push(i as i32);
            } else if players[i] == -1 {
                losers.push(i as i32);
            }
        }
        vec![winners, losers]
    }
}