impl Solution {
    pub fn monotone_increasing_digits(n: i32) -> i32 {
        
        if n < 10 {
            return n;
        }
        let mut v = Vec::new();
        let mut n = n;
        while n > 0 {
            v.push(n % 10);
            n = n / 10;
        }
        let mut i = v.len() - 1;
        while i > 0 {
            if v[i] > v[i - 1] {
                v[i - 1] -= 1;
                for j in i .. v.len() {
                    v[j] = 9;
                }
            }
            i -= 1;
        }
        let mut r = 0;
        for i in (0 .. v.len()).rev() {
            r = r * 10 + v[i];
        }
        r
    }
}