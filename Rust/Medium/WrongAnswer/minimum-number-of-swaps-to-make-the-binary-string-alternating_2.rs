impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let s = s.into_bytes();
        let n = s.len();
        let mut c0 = 0;
        let mut c1 = 0;
        for i in 0..n {
            if i % 2 == 0 {
                if s[i] == b'0' {
                    c0 += 1;
                } else {
                    c1 += 1;
                }
            } else {
                if s[i] == b'1' {
                    c0 += 1;
                } else {
                    c1 += 1;
                }
            }
        }
        if n % 2 == 0 {
            if c0 % 2 == 0 && c1 % 2 == 0 {
                return (c0 / 2 + c1 / 2) as i32;
            }
        } else {
            if c0 % 2 == 0 && c1 % 2 == 1 {
                return (c0 / 2 + (c1 - 1) / 2) as i32;
            }
            if c0 % 2 == 1 && c1 % 2 == 0 {
                return ((c0 - 1) / 2 + c1 / 2) as i32;
            }
        }
        -1
    }
}