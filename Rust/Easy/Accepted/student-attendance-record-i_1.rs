impl Solution {
    pub fn check_record(s: String) -> bool {
        
        let mut a = 0;
        let mut l = 0;
        for c in s.chars() {
            if c == 'A' {
                a += 1;
                l = 0;
            } else if c == 'L' {
                l += 1;
            } else {
                l = 0;
            }
            if a > 1 || l > 2 {
                return false;
            }
        }
        true
    }
}