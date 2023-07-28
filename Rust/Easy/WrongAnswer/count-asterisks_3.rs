impl Solution {
    pub fn count_asterisks(s: String) -> i32 {
        
        let mut count = 0;
        let mut asterisk = false;
        for c in s.chars() {
            if c == '*' {
                if asterisk {
                    asterisk = false;
                } else {
                    asterisk = true;
                }
            } else if c == '|' {
                if asterisk {
                    count += 1;
                    asterisk = false;
                }
            }
        }
        count
    }
}