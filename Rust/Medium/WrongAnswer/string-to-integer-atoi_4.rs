impl Solution {
    pub fn my_atoi(s: String) -> i32 {
        

        let mut s = s.trim().chars();
        let mut res = 0;
        let mut sign = 1;
        let mut sign_count = 0;
        while let Some(c) = s.next() {
            match c {
                '+' => {
                    if sign_count > 0 {
                        break;
                    }
                    sign_count += 1;
                }
                '-' => {
                    if sign_count > 0 {
                        break;
                    }
                    sign_count += 1;
                    sign = -1;
                }
                c if c.is_ascii_digit() => {
                    res = res * 10 + (c as i32 - '0' as i32);
                    if sign * res > i32::MAX as i32 {
                        return i32::MAX;
                    }
                    if sign * res < i32::MIN as i32 {
                        return i32::MIN;
                    }
                }
                _ => break,
            }
        }
        sign * res
    }
}