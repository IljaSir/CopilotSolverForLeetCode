impl Solution {
    pub fn my_atoi(s: String) -> i32 {
        

        let mut result = 0;
        let mut sign = 1;
        let mut i = 0;
        let mut is_sign = false;
        let mut is_num = false;
        while i < s.len() {
            let c = s.chars().nth(i).unwrap();
            if c == ' ' {
                if is_num || is_sign {
                    break;
                }
            } else if c == '-' {
                if is_num || is_sign {
                    break;
                }
                is_sign = true;
                sign = -1;
            } else if c == '+' {
                if is_num || is_sign {
                    break;
                }
                is_sign = true;
                sign = 1;
            } else if c >= '0' && c <= '9' {
                is_num = true;
                if result > (i32::MAX - (c as i32 - '0' as i32)) / 10 {
                    if sign == 1 {
                        return i32::MAX;
                    } else {
                        return i32::MIN;
                    }
                }
                result = result * 10 + (c as i32 - '0' as i32);
            } else {
                break;
            }
            i += 1;
        }
        return result * sign;
    }
}