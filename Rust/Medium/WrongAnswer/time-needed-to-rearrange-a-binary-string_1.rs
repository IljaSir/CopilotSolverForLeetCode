impl Solution {
    pub fn seconds_to_remove_occurrences(s: String) -> i32 {
        
        let mut count = 0;
        let mut zero = 0;
        for c in s.chars() {
            if c == '0' {
                zero += 1;
            } else {
                if zero > 0 {
                    zero -= 1;
                    count += 1;
                }
            }
        }
        count
    }
}