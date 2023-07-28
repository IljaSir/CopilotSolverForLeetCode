impl Solution {
    pub fn check_ones_segment(s: String) -> bool {
        
        let mut one = false;
        for c in s.chars() {
            if c == '1' {
                if one {
                    return false;
                }
                one = true;
            } else {
                one = false;
            }
        }
        true
    }
}