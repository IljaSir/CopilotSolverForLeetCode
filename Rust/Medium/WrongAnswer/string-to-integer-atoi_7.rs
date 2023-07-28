impl Solution {
    pub fn my_atoi(s: String) -> i32 {
        

        let mut result = 0;
        let mut is_negative = false;
        let mut is_positive = false;
        let mut is_number = false;
        let mut is_space = false;
        let mut is_start = true;
        for c in s.chars() {
            if is_start {
                if c == ' ' {
                    continue;
                }
                is_start = false;
            }
            if c == ' ' {
                if !is_number {
                    continue;
                }
                break;
            }
            if c == '-' {
                if is_negative || is_positive || is_number {
                    break;
                }
                is_negative = true;
                continue;
            }
            if c == '+' {
                if is_negative || is_positive || is_number {
                    break;
                }
                is_positive = true;
                continue;
            }
            if c.is_digit(10) {
                is_number = true;
                if is_negative {
                    if result > 214748364 {
                        return -2147483648;
                    }
                    if result == 214748364 {
                        if c == '8' {
                            return -2147483648;
                        }
                        if c == '9' {
                            return -2147483648;
                        }
                    }
                } else {
                    if result > 214748364 {
                        return 2147483647;
                    }
                    if result == 214748364 {
                        if c == '8' {
                            return 2147483647;
                        }
                        if c == '9' {
                            return 2147483647;
                        }
                    }
                }
                result = result * 10 + c.to_digit(10).unwrap() as i32;
                continue;
            }
            break;
        }
        if is_negative {
            -result
        } else {
            result
        }
    }
}