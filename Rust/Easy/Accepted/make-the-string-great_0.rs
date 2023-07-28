impl Solution {
    pub fn make_good(s: String) -> String {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            if let Some(&top) = stack.last() {
                if (top as i32 - c as i32).abs() == 32 {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        stack.into_iter().collect()
    }
}