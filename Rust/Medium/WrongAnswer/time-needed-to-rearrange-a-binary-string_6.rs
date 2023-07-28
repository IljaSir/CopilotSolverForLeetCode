impl Solution {
    pub fn seconds_to_remove_occurrences(s: String) -> i32 {
        
        let mut count = 0;
        let mut prev = ' ';
        for c in s.chars() {
            if c == '0' && prev == '1' {
                count += 1;
                prev = ' ';
            } else {
                prev = c;
            }
        }
        count
    }
}