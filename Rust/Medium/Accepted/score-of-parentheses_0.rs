impl Solution {
    pub fn score_of_parentheses(s: String) -> i32 {
        
        let mut stack = vec![0];
        for c in s.chars() {
            if c == '(' {
                stack.push(0);
            } else {
                let v = stack.pop().unwrap();
                let w = stack.pop().unwrap();
                stack.push(w + std::cmp::max(2 * v, 1));
            }
        }
        stack.pop().unwrap()
    }
}