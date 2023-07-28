impl Solution {
    pub fn check_ones_segment(s: String) -> bool {
        
        let mut seen_one = false;
        let mut seen_zero = false;
        for c in s.chars() {
            if c == '0' {
                if seen_one {
                    seen_zero = true;
                }
            } else {
                if seen_zero {
                    return false;
                }
                seen_one = true;
            }
        }
        true
    }
}