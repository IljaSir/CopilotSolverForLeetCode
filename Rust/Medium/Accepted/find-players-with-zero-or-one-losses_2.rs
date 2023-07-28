impl Solution {
    pub fn find_winners(matches: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut wins = vec![0; 100001];
        let mut losses = vec![0; 100001];
        for m in matches {
            let (w, l) = (m[0] as usize, m[1] as usize);
            wins[w] += 1;
            losses[l] += 1;
        }
        let mut winners = vec![];
        let mut losers = vec![];
        for i in 1..wins.len() {
            if wins[i] > 0 && losses[i] == 0 {
                winners.push(i as i32);
            }
            if losses[i] == 1 {
                losers.push(i as i32);
            }
        }
        vec![winners, losers]
    }
}