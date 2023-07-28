impl Solution {
    pub fn check_record(s: String) -> bool {
        
        let mut absent = 0;
        let mut late = 0;
        for c in s.chars() {
            if c == 'A' {
                absent += 1;
            } else if c == 'L' {
                late += 1;
            } else {
                late = 0;
            }
            if absent > 1 || late > 2 {
                return false;
            }
        }
        true
    }
}