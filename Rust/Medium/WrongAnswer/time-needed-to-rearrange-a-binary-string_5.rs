impl Solution {
    pub fn seconds_to_remove_occurrences(s: String) -> i32 {
        
        let mut count = 0;
        let mut zero_count = 0;
        for c in s.chars() {
            if c == '0' {
                zero_count += 1;
            } else {
                count = std::cmp::max(count, zero_count);
            }
        }
        count
    }
}