impl Solution {
    pub fn find_substring_in_wrapround_string(s: String) -> i32 {
        

        let mut res = 0;
        let mut dp = vec![0; 26];
        let mut cur = 0;
        let s = s.as_bytes();
        for i in 0..s.len() {
            if i > 0 && (s[i] - s[i - 1] == 1 || s[i - 1] - s[i] == 25) {
                cur += 1;
            } else {
                cur = 1;
            }
            let index = (s[i] - b'a') as usize;
            dp[index] = dp[index].max(cur);
        }
        for i in 0..26 {
            res += dp[i];
        }
        res
    }
}