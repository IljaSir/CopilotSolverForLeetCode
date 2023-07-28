impl Solution {
    pub fn remove_outer_parentheses(s: String) -> String {
        
        let mut res = String::new();
        let mut stack = 0;
        for c in s.chars() {
            if c == '(' {
                if stack > 0 {
                    res.push(c);
                }
                stack += 1;
            } else {
                if stack > 1 {
                    res.push(c);
                }
                stack -= 1;
            }
        }
        res
    }
}