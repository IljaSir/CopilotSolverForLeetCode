impl Solution {
    pub fn check_record(s: String) -> bool {
        
        let mut a_cnt = 0;
        let mut l_cnt = 0;
        for c in s.chars() {
            match c {
                'A' => {
                    if a_cnt == 1 {
                        return false;
                    }
                    a_cnt += 1;
                    l_cnt = 0;
                }
                'L' => {
                    if l_cnt == 2 {
                        return false;
                    }
                    l_cnt += 1;
                }
                _ => {
                    l_cnt = 0;
                }
            }
        }
        true
    }
}