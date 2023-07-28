impl Solution {
    pub fn num_ways(s: String) -> i32 {
        
        let n = s.len();
        let mut count = 0;
        for c in s.chars() {
            if c == '1' {
                count += 1;
            }
        }
        if count % 3 != 0 {
            return 0;
        }
        if count == 0 {
            return ((n - 1) * (n - 2) / 2) as i32 % 1000000007;
        }
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut l = 0;
        let mut m = 0;
        let mut n = 0;
        let mut p = 0;
        let mut q = 0;
        let mut r = 0;
        let mut s = 0;
        let mut t = 0;
        let mut u = 0;
        for c in s.chars() {
            if c == '1' {
                p += 1;
                if p == count / 3 {
                    i = j;
                }
                if p == count / 3 * 2 {
                    k = l;
                }
                if p == count {
                    m = n;
                }
            }
            j += 1;
            l += 1;
            n += 1;
        }
        for c in s.chars() {
            if c == '1' {
                q += 1;
                if q == count / 3 + 1 {
                    r = s;
                }
                if q == count / 3 * 2 + 1 {
                    t = u;
                }
            }
            s += 1;
            u += 1;
        }
        return ((i - k + 1) * (r - t + 1)) as i32 % 1000000007;
    }
}