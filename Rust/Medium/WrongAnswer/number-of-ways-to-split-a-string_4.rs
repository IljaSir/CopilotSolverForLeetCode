impl Solution {
    pub fn num_ways(s: String) -> i32 {
        
        let s = s.as_bytes();
        let ones = s.iter().filter(|&&x| x == b'1').count();
        if ones % 3 != 0 {
            return 0;
        }
        if ones == 0 {
            let n = s.len();
            return ((n - 1) * (n - 2) / 2) as i32 % 1000000007;
        }
        let ones = ones / 3;
        let mut idx = 0;
        let mut cnt = 0;
        let mut ans = 1;
        for i in 0..s.len() {
            if s[i] == b'1' {
                cnt += 1;
                if cnt == ones {
                    idx = i;
                    break;
                }
            }
        }
        let mut i = idx + 1;
        while s[i] == b'0' {
            i += 1;
        }
        ans *= (i - idx) as i32;
        ans %= 1000000007;
        for i in idx + 1..s.len() {
            if s[i] == b'1' {
                cnt += 1;
                if cnt == 2 * ones {
                    idx = i;
                    break;
                }
            }
        }
        let mut i = idx + 1;
        while s[i] == b'0' {
            i += 1;
        }
        ans *= (i - idx) as i32;
        ans %= 1000000007;
        ans
    }
}