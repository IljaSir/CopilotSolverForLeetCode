impl Solution {
    pub fn check_string(s: String) -> bool {
        
        let mut a = 0;
        let mut b = 0;
        for ch in s.chars() {
            if ch == 'a' {
                a += 1;
            } else {
                b += 1;
            }
            if a < b {
                return false;
            }
        }
        true
    }
}