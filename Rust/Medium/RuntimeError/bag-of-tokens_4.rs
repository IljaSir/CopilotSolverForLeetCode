impl Solution {
    pub fn bag_of_tokens_score(tokens: Vec<i32>, power: i32) -> i32 {
        
        let mut tokens = tokens;
        tokens.sort();
        let (mut l, mut r) = (0, tokens.len() - 1);
        let (mut score, mut max_score) = (0, 0);
        let (mut p) = (power);
        while l <= r {
            if p >= tokens[l] {
                p -= tokens[l];
                score += 1;
                l += 1;
                max_score = max_score.max(score);
            } else if score > 0 {
                p += tokens[r];
                score -= 1;
                r -= 1;
            } else {
                break;
            }
        }
        max_score
    }
}