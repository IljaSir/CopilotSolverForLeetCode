impl Solution {
    pub fn seconds_to_remove_occurrences(s: String) -> i32 {
        
        let mut count = 0;
        let mut count0 = 0;
        for c in s.chars() {
            if c == '0' {
                count0 += 1;
            } else {
                if count0 > 0 {
                    count += 1;
                    count0 -= 1;
                }
            }
        }
        count
    }
}