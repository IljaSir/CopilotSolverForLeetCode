impl Solution {
    pub fn check_string(s: String) -> bool {
        
        let mut a = false;
        for c in s.chars() {
            if c == 'a' {
                a = true;
            } else if c == 'b' && !a {
                return false;
            }
        }
        true
    }
}