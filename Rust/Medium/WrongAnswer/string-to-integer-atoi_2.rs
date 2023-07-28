impl Solution {
    pub fn my_atoi(s: String) -> i32 {
        

        let s = s.trim();
        let mut neg = false;
        let mut i = 0;
        let mut res = 0;
        if s.len() == 0 {
            return 0;
        }
        if s.chars().nth(0).unwrap() == '-' {
            neg = true;
            i += 1;
        } else if s.chars().nth(0).unwrap() == '+' {
            i += 1;
        }
        while i < s.len() {
            let c = s.chars().nth(i).unwrap();
            if c < '0' || c > '9' {
                break;
            }
            let d = c as i32 - '0' as i32;
            if neg {
                if res < (std::i32::MIN + d) / 10 {
                    return std::i32::MIN;
                }
            } else {
                if res > (std::i32::MAX - d) / 10 {
                    return std::i32::MAX;
                }
            }
            res = res * 10 + d;
            i += 1;
        }
        if neg {
            -res
        } else {
            res
        }
    }
}