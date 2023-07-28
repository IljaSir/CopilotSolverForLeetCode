impl Solution {
    pub fn remove_outer_parentheses(s: String) -> String {
        
        let mut ans = String::new();
        let mut count = 0;
        for c in s.chars() {
            if c == '(' {
                if count > 0 {
                    ans.push(c);
                }
                count += 1;
            } else {
                count -= 1;
                if count > 0 {
                    ans.push(c);
                }
            }
        }
        ans
    }
}