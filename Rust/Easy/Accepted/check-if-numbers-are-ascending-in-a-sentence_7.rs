impl Solution {
    pub fn are_numbers_ascending(s: String) -> bool {
        
        let mut last: Option<i32> = None;
        let mut is_num = false;
        let mut num = 0;
        for c in s.chars() {
            if c.is_digit(10) {
                is_num = true;
                num = num * 10 + c.to_digit(10).unwrap() as i32;
            } else {
                if is_num {
                    if last.is_none() || last.unwrap() < num {
                        last = Some(num);
                        is_num = false;
                        num = 0;
                    } else {
                        return false;
                    }
                }
            }
        }
        if is_num {
            if last.is_none() || last.unwrap() < num {
                last = Some(num);
            } else {
                return false;
            }
        }
        true
    }
}