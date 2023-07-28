impl Solution {
    pub fn longest_prefix(s: String) -> String {
        
        let mut ans = String::new();
        let mut l = 0;
        let mut r = 1;
        let chars: Vec<char> = s.chars().collect();
        let mut dp = vec![0; s.len()];
        while r < s.len() {
            if chars[l] == chars[r] {
                dp[r] = l + 1;
                l += 1;
                r += 1;
            } else {
                if l == 0 {
                    r += 1;
                } else {
                    l = dp[l - 1];
                }
            }
        }
        ans = s[0..dp[s.len() - 1]].to_string();
        ans
    }
}