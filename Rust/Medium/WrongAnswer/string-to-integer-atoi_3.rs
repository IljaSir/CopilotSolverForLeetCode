impl Solution {
    pub fn my_atoi(s: String) -> i32 {
        

        let mut sign = 1;
        let mut ans = 0;
        let mut start = false;
        for c in s.chars() {
            if start {
                if c.is_digit(10) {
                    ans = ans * 10 + (c as i32 - '0' as i32);
                    if ans * sign > i32::MAX as i32 {
                        return i32::MAX;
                    }
                    if ans * sign < i32::MIN as i32 {
                        return i32::MIN;
                    }
                } else {
                    break;
                }
            } else {
                if c == ' ' {
                    continue;
                }
                if c == '-' {
                    sign = -1;
                    start = true;
                } else if c == '+' {
                    start = true;
                } else if c.is_digit(10) {
                    ans = c as i32 - '0' as i32;
                    start = true;
                } else {
                    break;
                }
            }
        }
        ans * sign
    }
}