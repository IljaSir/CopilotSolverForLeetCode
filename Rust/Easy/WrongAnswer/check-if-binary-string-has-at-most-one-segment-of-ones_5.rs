impl Solution {
    pub fn check_ones_segment(s: String) -> bool {
        
        let mut result = true;
        let mut one = false;
        for c in s.chars() {
            if c == '1' {
                if one {
                    result = false;
                } else {
                    one = true;
                }
            } else {
                one = false;
            }
        }
        result
    }
}