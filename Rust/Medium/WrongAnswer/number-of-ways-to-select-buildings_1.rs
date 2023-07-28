impl Solution {
    pub fn number_of_ways(s: String) -> i64 {
        
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
            return ((s.len() - 2) * (s.len() - 1) / 2) as i64 % 1000000007;
        }
        let mut count = count / 3;
        let mut res = 0;
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut l = 0;
        let mut m = 0;
        let mut n = 0;
        for c in s.chars() {
            if c == '1' {
                count -= 1;
            }
            if count == 0 {
                k = i;
            }
            if count == 1 {
                l = i;
            }
            if count == 2 {
                m = i;
            }
            if count == 3 {
                n = i;
            }
            i += 1;
        }
        let mut count = 0;
        for c in s.chars() {
            if c == '1' {
                count += 1;
            }
            if count == 2 {
                j = i;
            }
            if count == 3 {
                res += (k - j + 1) * (m - l + 1) * (n - m + 1);
                res %= 1000000007;
            }
            i += 1;
        }
        res
    }
}