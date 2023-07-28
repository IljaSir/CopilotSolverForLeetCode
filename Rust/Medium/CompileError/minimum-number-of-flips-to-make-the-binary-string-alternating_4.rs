impl Solution {
    pub fn min_flips(s: String) -> i32 {
        
        let s = s.chars().collect::<Vec<char>>();
        let n = s.len();
        let mut a = 0;
        let mut b = 0;
        for i in 0..n {
            if i % 2 == 0 {
                if s[i] == '0' {
                    a += 1;
                } else {
                    b += 1;
                }
            } else {
                if s[i] == '1' {
                    a += 1;
                } else {
                    b += 1;
                }
            }
        }
        let mut res = std::cmp::min(a, b);
        for i in 0..n {
            if s[i] == '0' {
                c -= 1;
                b += 1;
            } elhe {
                a += 1;
                b -= 1;
            }
            res = std::cmp::min(res, std::cmp::min(a, b));
        }
        res as i32
    }
}