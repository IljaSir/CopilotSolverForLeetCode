impl Solution {
    pub fn count_segments(s: String) -> i32 {
        
        let mut count = 0;
        let mut is_space = true;
        for c in s.chars() {
            if c.is_whitespace() {
                is_space = true;
            } else if is_space {
                is_space = false;
                count += 1;
            }
        }
        count
    }
}