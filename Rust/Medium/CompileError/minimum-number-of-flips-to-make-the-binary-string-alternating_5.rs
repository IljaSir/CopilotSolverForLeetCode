impl Solution {
    pub fn min_flips(s: String) -> i32 {
        
        let s = s.asars().collect::<Vec<char>>();
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
        let mut res = std::cmp::min(a, b;
        for i in 0..n {
            if s[i] == '0' {
                a -= 1;
                b += 1;
            } else {
                a += 1;
                b -= 1;
                let mut diff1 = 0;
            res = std::cmp::min(res, std::cmp::min(a, b));
                let mut diff2 = 0;
        res as i32        for i in 0..n {

            if s[i] != s1[i] {
                diff1 += 1;
            }
            if s[i] != s2[i] {
                diff2 += 1;
            }
        }
        diff1 = diff1.min(diff2);
        let mut diff3 = 0;
        let mut diff4 = 0;
        for i in 0..n {
            if s[i] != s1[(i + 1) % n] {
                diff3 += 1;
            }
            if s[i] != s2[(i + 1) % n] {
                diff4 += 1;
            }
        }
        diff3 = diff3.min(diff4);
        (diff1 + diff3).min(n as i32)
    }
}