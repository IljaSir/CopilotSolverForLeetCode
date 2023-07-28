impl Solution {
    pub fn are_numbers_ascending(s: String) -> bool {
        
        let mut prev = 0;
        let mut num = 0;
        let mut is_num = false;
        for c in s.chars() {
            if c.is_numeric() {
                num = num * 10 + c.to_digit(10).unwrap();
                is_num = true;
            } else {
                if is_num && num <= prev {
                    return false;
                }
                prev = num;
                num = 0;
                is_num = false;
            }
        }
        if is_num && num <= prev {
            return false;
        }
        true
    }
}