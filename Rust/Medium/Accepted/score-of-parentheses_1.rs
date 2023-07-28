impl Solution {
    pub fn score_of_parentheses(s: String) -> i32 {
        
        let mut stack = vec![];
        let mut score = 0;
        for c in s.chars() {
            if c == '(' {
                stack.push(score);
                score = 0;
            } else {
                score = stack.pop().unwrap() + std::cmp::max(score * 2, 1);
            }
        }
        score
    }
}