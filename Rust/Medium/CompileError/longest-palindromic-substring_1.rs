impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        

        let s = s.as_bytes();
        let n = s.len();
        let mut dp = vec![vec![false; n]; n];
        let (mut i, mut j) = (0, 0);
        for l in 0..n {
            for i in 0..n - l {
                let j = i + l;
                if l == 0 {
                    dp[i][j] = true;
                } else if l == 1 {
                    dp[i][j] = s[i] == s[j];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j];
                }
                if dp[i][j] && l > j - i {
                    i = i;
                    j = j;
                }
            }
        }
        String::from_utf8(s[i..=j].to_vec()).unwrap()
    }
}