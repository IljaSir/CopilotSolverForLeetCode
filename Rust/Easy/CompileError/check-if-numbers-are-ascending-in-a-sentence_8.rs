impl Solution {
    pub fn are_numbers_ascending(s: String) -> bool {
        
        let mut last_num = -1;
        let mut num = 0;
        let mut has_num = false;
        for c in s.chars() {
            if c.is_digit(10) {
                num = num * 10 + c.to_digit(10).unwrap();
                has_num = true;
            } else {
                if has_num {
                    if num <= last_num {
                        return false;
                    }
                    last_num = num;
                    num = 0;
                    has_num = false;
                }
            }
        }
        if has_num {
            if num <= last_num {
                return false;
            }
        }
        true
    }
}