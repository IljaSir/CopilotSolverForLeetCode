impl Solution {
    pub fn bag_of_tokens_score(tokens: Vec<i32>, power: i32) -> i32 {
        
        let mut tokens = tokens;
        tokens.sort();
        let (mut l, mut r) = (0, tokens.len()-1);
        let (mut score, mut best) = (0, 0);
        while l <= r {
            if power >= tokens[l] {
                score += 1;
                best = best.max(score);
                power -= tokens[l];
                l += 1;
            } else if score > 0 {
                score -= 1;
                power += tokens[r];
                r -= 1;
            } else {
                break;
            }
        }
        best
    }
}