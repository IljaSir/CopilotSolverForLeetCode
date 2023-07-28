impl Solution {
    pub fn find_winners(matches: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut winners = vec![];
        let mut losers = vec![];
        for m in matches {
            let (w, l) = (m[0], m[1]);
            if !winners.contains(&w) {
                winners.push(w);
            }
            if !losers.contains(&l) {
                losers.push(l);
            }
            if let Some(idx) = winners.iter().position(|&x| x == l) {
                winners.remove(idx);
            }
            if let Some(idx) = losers.iter().position(|&x| x == w) {
                losers.remove(idx);
            }
        }
        vec![winners, losers]
    }
}