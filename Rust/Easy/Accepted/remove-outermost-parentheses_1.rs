impl Solution {
    pub fn remove_outer_parentheses(s: String) -> String {
        
        let mut res = String::new();
        let mut count = 0;
        for c in s.chars() {
            if c == '(' {
                count += 1;
                if count > 1 {
                    res.push(c);
                }
            } else if c == ')' {
                if count > 1 {
                    res.push(c);
                }
                count -= 1;
            }
        }
        res
    }
}