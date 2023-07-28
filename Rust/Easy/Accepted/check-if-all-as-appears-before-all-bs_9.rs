impl Solution {
    pub fn check_string(s: String) -> bool {
        
        let mut a = 0;
        let mut b = 0;
        for c in s.chars() {
            if c == 'b' {
                b += 1;
            } else if b > 0 {
                return false;
            } else {
                a += 1;
            }
        }
        true
    }
}