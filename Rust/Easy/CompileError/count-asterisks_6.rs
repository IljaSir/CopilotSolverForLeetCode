impl Solution {
    pub fn count_asterisks(s: String) -> i32 {
        
        let mut count = 0;
        for c in s.chars() {
            if c == '*' {
                count += 1;
            }
        }
        count - (s.len() - s.replace("|", "").len()) / 2
    }
}