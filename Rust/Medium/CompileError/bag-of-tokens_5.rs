impl Solution {
    pub fn bag_of_tokens_score(tokens: Vec<i32>, power: i32) -> i32 {
        
        let mut tokens = tokens;
        tokens.sort();
        let mut i = 0;
        let mut j = tokens.len() - 1;
        let mut score = 0;
        let mut best = 0;
        while i <= j {
            if tokens[i] <= power {
                power -= tokens[i];
                score += 1;
                i += 1;
                best = best.max(score);
            } else if score > 0 {
                power += tokens[j];
                score -= 1;
                j -= 1;
            } else {
                break;
            }
        }
        best
    }
}