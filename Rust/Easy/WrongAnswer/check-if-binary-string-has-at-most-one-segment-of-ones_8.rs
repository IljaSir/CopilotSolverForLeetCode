impl Solution {
    pub fn check_ones_segment(s: String) -> bool {
        
        let mut i = 0;
        let mut is_one = false;
        for c in s.chars() {
            if c == '1' {
                if is_one {
                    i += 1;
                } else {
                    is_one = true;
                }
            } else {
                is_one = false;
            }
        }
        i == 0
    }
}