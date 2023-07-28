impl Solution {
    pub fn my_atoi(s: String) -> i32 {
        

        let mut s = s.trim();
        let mut is_negative = false;
        if s.len() == 0 {
            return 0;
        }
        if s.starts_with('-') {
            is_negative = true;
            s = &s[1..];
        } else if s.starts_with('+') {
            s = &s[1..];
        }
        let mut num = 0;
        for c in s.chars() {
            if c < '0' || c > '9' {
                break;
            }
            num = num * 10 + (c as i32 - '0' as i32);
            if num > i32::MAX {
                break;
            }
        }
        if is_negative {
            num = -num;
        }
        if num > i32::MAX {
            return i32::MAX;
        }
        if num < i32::MIN {
            return i32::MIN;
        }
        num
    }
}