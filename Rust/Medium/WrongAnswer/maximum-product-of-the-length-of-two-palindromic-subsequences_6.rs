impl Solution {
    pub fn max_product(s: String) -> i32 {
        
        let n = s.len();
        let mut dp = vec![0; 1 << n];
        for i in 0..n {
            for j in i..n {
                let mut mask = 0;
                for k in i..=j {
                    mask |= 1 << k;
                }
                if Self::is_palindrome(&s, i, j) {
                    dp[mask] = j - i + 1;
                }
            }
        }
        for i in 0..1 << n {
            for j in 0..1 << n {
                dp[i | j] = dp[i | j].max(dp[i] * dp[j]);
            }
        }
        dp[(1 << n) - 1] as i32
    }
    fn is_palindrome(s: &str, i: usize, j: usize) -> bool {
        let mut i = i;
        let mut j = j;
        while i < j {
            if s.as_bytes()[i] != s.as_bytes()[j] {
                return false;
            }
            i += 1;
            j -= 1;
        }
        true
    }
}