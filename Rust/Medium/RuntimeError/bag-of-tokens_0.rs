impl Solution {
    pub fn bag_of_tokens_score(tokens: Vec<i32>, power: i32) -> i32 {
        
        let mut tokens = tokens;
        tokens.sort();
        let mut i = 0;
        let mut j = tokens.len() - 1;
        let mut score = 0;
        let mut max_score = 0;
        let mut power = power;
        while i <= j {
            if power >= tokens[i] {
                power -= tokens[i];
                i += 1;
                score += 1;
                max_score = max_score.max(score);
            } else if score > 0 {
                power += tokens[j];
                j -= 1;
                score -= 1;
            } else {
                break;
            }
        }
        max_score
    }
}