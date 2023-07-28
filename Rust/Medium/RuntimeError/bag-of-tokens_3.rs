impl Solution {
    pub fn bag_of_tokens_score(tokens: Vec<i32>, power: i32) -> i32 {
        
        let mut tokens = tokens;
        let mut power = power;
        let mut score = 0;
        let mut max_score = 0;
        tokens.sort();
        let mut i = 0;
        let mut j = tokens.len() - 1;
        while i <= j {
            if power >= tokens[i] {
                power -= tokens[i];
                score += 1;
                i += 1;
                max_score = max_score.max(score);
            } else if score > 0 {
                power += tokens[j];
                score -= 1;
                j -= 1;
            } else {
                break;
            }
        }
        max_score
    }
}