impl Solution {
    pub fn check_ones_segment(s: String) -> bool {
        
        let mut res = true;
        let mut flag = false;
        for c in s.chars() {
            if c == '0' {
                flag = true;
            } else {
                if flag {
                    res = false;
                    break;
                }
            }
        }
        res
    }
}