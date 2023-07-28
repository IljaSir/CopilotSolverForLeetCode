impl Solution {
    pub fn min_flips(s: String) -> i32 {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut a = 0;
        let mut b = 0;
        for i in 0..n {
            if (i & 1) == 0 {
                if s[i] != b'0' {
                    a += 1;
                }
                if s[i] != b'1' {
                    b += 1;
                }
            } else {
                if s[i] != b'1' {
                    a += 1;
                }
                if s[i] != b'0' {
                    b += 1;
                }
            }
        }
        std::cmp::min(a, b)
    }
}