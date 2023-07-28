impl Solution {
    pub fn find_substring_in_wrapround_string(s: String) -> i32 {
        

        let s = s.as_bytes();
        let mut dp = vec![0; 26];
        let mut len = 0;
        for i in 0..s.len() {
            if i > 0 && (s[i] as i32 - s[i - 1] as i32 == 1 || s[i - 1] as i32 - s[i] as i32 == 25) {
                len += 1;
            } else {
                len = 1;
            }
            let idx = (s[i] - b'a') as usize;
            dp[idx] = dp[idx].max(len);
        }
        dp.iter().sum()
    }
}