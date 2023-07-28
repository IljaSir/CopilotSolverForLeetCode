impl Solution {
    pub fn check_string(s: String) -> bool {
        
        let mut a = 0;
        let mut b = 0;
        for c in s.chars() {
            match c {
                'a' => a += 1,
                _ => b += 1,
            }
            if b > a {
                return false;
            }
        }
        true
    }
}