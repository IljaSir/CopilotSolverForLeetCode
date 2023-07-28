impl Solution {
    pub fn check_ones_segment(s: String) -> bool {
        
        let mut has_one = false;
        let mut has_zero = false;
        for c in s.chars() {
            if c == '1' {
                if has_zero {
                    return false;
                }
                has_one = true;
            } else {
                has_zero = true;
            }
        }
        has_one
    }
}