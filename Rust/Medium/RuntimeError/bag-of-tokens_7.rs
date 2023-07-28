impl Solution {
    pub fn bag_of_tokens_score(tokens: Vec<i32>, power: i32) -> i32 {
        
        let mut tokens = tokens;
        tokens.sort();
        let (mut l, mut r) = (0, tokens.len() - 1);
        let mut p = power;
        let mut score = 0;
        while l <= r {
            if p >= tokens[l] {
                p -= tokens[l];
                l += 1;
                score += 1;
            } else if score > 0 && l < r {
                p += tokens[r];
                r -= 1;
                score -= 1;
            } else {
                break;
            }
        }
        score
    }
}