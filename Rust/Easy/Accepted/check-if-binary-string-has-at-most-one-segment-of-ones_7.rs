impl Solution {
    pub fn check_ones_segment(s: String) -> bool {
        
        let mut result = true;
        let mut is_zero = false;
        for c in s.chars() {
            if is_zero {
                if c == '1' {
                    result = false;
                    break;
                }
            } else {
                if c == '0' {
                    is_zero = true;
                }
            }
        }
        return result;
    }
}