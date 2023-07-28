impl Solution {
    pub fn max_depth(s: String) -> i32 {
        
        let mut stack = Vec::new();
        let mut max_depth = 0;
        for c in s.chars() {
            match c {
                '(' => {
                    stack.push('(');
                    max_depth = max_depth.max(stack.len() as i32);
                }
                ')' => {
                    stack.pop();
                }
                _ => {}
            }
        }
        max_depth
    }
}