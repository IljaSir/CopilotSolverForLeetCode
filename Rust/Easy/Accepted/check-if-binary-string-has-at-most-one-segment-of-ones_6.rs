impl Solution {
    pub fn check_ones_segment(s: String) -> bool {
        
        let mut count = 0;
        let mut flag = true;
        for i in s.bytes() {
            if i == b'1' {
                if flag {
                    count += 1;
                    flag = false;
                }
            } else {
                flag = true;
            }
        }
        count == 1
    }
}