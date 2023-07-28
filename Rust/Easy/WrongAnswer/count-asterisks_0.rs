impl Solution {
    pub fn count_asterisks(s: String) -> i32 {
        
        let mut count = 0;
        let mut asterisk = false;
        for c in s.chars() {
            if c == '|' {
                asterisk = !asterisk;
            } else if asterisk {
                count += 1;
            }
        }
        count
    }
}