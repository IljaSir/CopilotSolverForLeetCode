impl Solution {
    pub fn check_string(s: String) -> bool {
        
        let mut a = 0;
        let mut b = 0;
        for c in s.chars() {
            if c == 'a' {
                a += 1;
            } else {
                b += 1;
            }
            if b > 0 && a == 0 {
                return false;
            }
        }
        true
    }
}