impl Solution {
    pub fn my_atoi(s: String) -> i32 {
        

        let mut result = 0i64;
        let mut sign = 1;
        let mut is_sign = false;
        let mut is_number = false;
        for c in s.chars() {
            if c == ' ' {
                if is_number {
                    break;
                }
                continue;
            }
            if c == '-' {
                if is_sign {
                    break;
                }
                is_sign = true;
                sign = -1;
                continue;
            }
            if c == '+' {
                if is_sign {
                    break;
                }
                is_sign = true;
                continue;
            }
            if c.is_digit(10) {
                is_number = true;
                result = result * 10 + (c.to_digit(10).unwrap() as i64);
                if result > i32::MAX as i64 {
                    break;
                }
            } else {
                break;
            }
        }
        result = result * sign;
        if result > i32::MAX as i64 {
            return i32::MAX;
        }
        if result < i32::MIN as i64 {
            return i32::MIN;
        }
        return result as i32;
    }
}