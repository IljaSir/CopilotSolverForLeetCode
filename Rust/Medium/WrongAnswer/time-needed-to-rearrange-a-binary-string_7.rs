impl Solution {
    pub fn seconds_to_remove_occurrences(s: String) -> i32 {
        
        let mut count = 0;
        let mut last = 0;
        for c in s.chars() {
            if c == '1' {
                count += 1;
            } else {
                if last == 1 {
                    count -= 1;
                }
            }
            last = c as i32 - 48;
        }
        count
    }
}