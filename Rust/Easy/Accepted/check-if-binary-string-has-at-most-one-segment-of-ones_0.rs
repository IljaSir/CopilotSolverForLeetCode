impl Solution {
    pub fn check_ones_segment(s: String) -> bool {
        
        let mut found = false;
        for c in s.chars() {
            if c == '1' {
                if found {
                    return false;
                }
            } else {
                found = true;
            }
        }
        true
    }
}