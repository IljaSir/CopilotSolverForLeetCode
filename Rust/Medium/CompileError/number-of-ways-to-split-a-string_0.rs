impl Solution {
    pub fn num_ways(s: String) -> i32 {
        
        let mut ones = 0;
        for c in s.chars() {
            if c == '1' {
                ones += 1;
            }
        }
        if ones % 3 != 0 {
            return 0;
        }
        if ones == 0 {
            return ((s.len() - 1) * (s.len() - 2) / 2) as i32 % 1000000007;
        }
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut l = 0;
        let mut m = 0;
        let mut n = 0;
        let mut o = 0;
        let mut p = 0;
        let mut q = 0;
        let mut r = 0;
        let mut s = 0;
        let mut t = 0;
        let mut u = 0;
        let mut v = 0;
        let mut w = 0;
        let mut x = 0;
        let mut y = 0;
        let mut z = 0;
        let mut a = 0;
        let mut b = 0;
        let mut c = 0;
        let mut d = 0;
        let mut e = 0;
        for c in s.chars() {
            if c == '1' {
                if i == 0 {
                    i = 1;
                } else if j == 0 {
                    j = 1;
                } else if k == 0 {
                    k = 1;
                } else if l == 0 {
                    l = 1;
                } else if m == 0 {
                    m = 1;
                } else if n == 0 {
                    n = 1;
                } else if o == 0 {
                    o = 1;
                } else if p == 0 {
                    p = 1;
                } else if q == 0 {
                    q = 1;
                } else if r == 0 {
                    r = 1;
                } else if s == 0 {
                    s = 1;
                } else if t == 0 {
                    t = 1;
                } else if u == 0 {
                    u = 1;
                } else if v == 0 {
                    v =
    }
}