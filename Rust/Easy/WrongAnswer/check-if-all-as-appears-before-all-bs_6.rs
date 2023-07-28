impl Solution {
    pub fn check_string(s: String) -> bool {
        
        let mut a = 0;
        let mut b = 0;
        for i in s.chars() {
            if i == 'a' {
                a += 1;
            }
            if i == 'b' {
                b += 1;
            }
            if b > 0 && a == 0 {
                return false;
            }
        }
        true
    }
}