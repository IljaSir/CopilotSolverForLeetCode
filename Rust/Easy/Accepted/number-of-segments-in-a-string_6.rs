impl Solution {
    pub fn count_segments(s: String) -> i32 {
        
        let s = s.trim();
        if s.is_empty() {
            return 0;
        }
        let mut count = 0;
        let mut last = ' ';
        for c in s.chars() {
            if c == ' ' && last != ' ' {
                count += 1;
            }
            last = c;
        }
        count + 1
    }
}