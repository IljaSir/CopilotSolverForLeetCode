impl Solution {
    pub fn check_string(s: String) -> bool {
        
        let mut a = -1;
        let mut b = -1;
        for (i, c) in s.chars().enumerate() {
            if c == 'a' && a == -1 {
                a = i as i32;
            }
            if c == 'b' && b == -1 {
                b = i as i32;
            }
            if a != -1 && b != -1 && a > b {
                return false;
            }
        }
        true
    }
}