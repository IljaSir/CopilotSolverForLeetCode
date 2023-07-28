impl Solution {
    pub fn bag_of_tokens_score(tokens: Vec<i32>, power: i32) -> i32 {
        
        if tokens.len() == 0 {
            return 0;
        }
        let mut tokens = tokens;
        tokens.sort();
        let mut score = 0;
        let mut max_score = 0;
        let mut left = 0;
        let mut right = tokens.len() - 1;
        while left <= right {
            if power >= tokens[left] {
                power -= tokens[left];
                left += 1;
                score += 1;
                max_score = max_score.max(score);
            } else if score > 0 {
                power += tokens[right];
                right -= 1;
                score -= 1;
            } else {
                break;
            }
        }
        max_score
    }
}