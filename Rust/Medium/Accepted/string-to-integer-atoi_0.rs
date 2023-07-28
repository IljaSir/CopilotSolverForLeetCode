impl Solution {
    pub fn my_atoi(s: String) -> i32 {
        

        let mut s = s;
        s = s.trim_start().to_string();
        if s.len() == 0 {
            return 0;
        }
        let mut sign = 1;
        let mut i = 0;
        if s.chars().nth(0).unwrap() == '-' {
            sign = -1;
            i += 1;
        } else if s.chars().nth(0).unwrap() == '+' {
            sign = 1;
            i += 1;
        }
        let mut ans = 0;
        while i < s.len() {
            let c = s.chars().nth(i).unwrap();
            if c < '0' || c > '9' {
                break;
            }
            let digit = (c as u8 - '0' as u8) as i32;
            if ans > (std::i32::MAX - digit) / 10 {
                if sign == 1 {
                    return std::i32::MAX;
                } else {
                    return std::i32::MIN;
                }
            }
            ans = ans * 10 + digit;
            i += 1;
        }
        ans * sign
    }
}