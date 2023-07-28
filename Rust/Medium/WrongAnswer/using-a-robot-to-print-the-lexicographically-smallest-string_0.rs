impl Solution {
    pub fn robot_with_string(s: String) -> String {
        
        let mut stack = vec![];
        for c in s.chars() {
            while !stack.is_empty() && stack[stack.len() - 1] > c {
                stack.pop();
            }
            stack.push(c);
        }
        stack.into_iter().collect()
    }
}