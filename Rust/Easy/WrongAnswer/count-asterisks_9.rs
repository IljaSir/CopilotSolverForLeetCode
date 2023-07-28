impl Solution {
    pub fn count_asterisks(s: String) -> i32 {
        
        let mut res = 0;
        let mut is_asterisk = false;
        for c in s.chars() {
            if c == '*' {
                is_asterisk = true;
            } else if c == '|' && is_asterisk {
                res += 1;
                is_asterisk = false;
            }
        }
        res
    }
}