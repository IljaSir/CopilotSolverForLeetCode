impl Solution {
    pub fn my_atoi(s: String) -> i32 {
        

        let mut s = s;
        let mut sign = 1;
        let mut start = 0;
        let mut end = 0;
        let mut res = 0;
        let mut overflow = false;
        let mut i = 0;
        while i < s.len() {
            if s[i..i+1].chars().nth(0).unwrap() == ' ' {
                i += 1;
            } else {
                break;
            }
        }
        if i < s.len() {
            if s[i..i+1].chars().nth(0).unwrap() == '-' {
                sign = -1;
                i += 1;
            } else if s[i..i+1].chars().nth(0).unwrap() == '+' {
                i += 1;
            }
        }
        start = i;
        while i < s.len() {
            if s[i..i+1].chars().nth(0).unwrap().is_digit(10) {
                i += 1;
            } else {
                break;
            }
        }
        end = i;
        if start == end {
            return 0;
        }
        s = s[start..end].to_string();
        if s.len() > 10 {
            if sign == 1 {
                return i32::MAX;
            } else {
                return i32::MIN;
            }
        }
        for c in s.chars() {
            if c.is_digit(10) {
                let n = c.to_digit(10).unwrap();
                if res > 214748364 {
                    overflow = true;
                    break;
                }
                res = res * 10 + n;
            }
        }
        if res > 214748364 {
            overflow = true;
        }
        if overflow {
            if sign == 1 {
                return i32::MAX;
            } else {
                return i32::MIN;
            }
        }
        (res as i32) * sign
    }
}