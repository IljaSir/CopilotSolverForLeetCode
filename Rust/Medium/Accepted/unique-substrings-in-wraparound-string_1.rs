impl Solution {
    pub fn find_substring_in_wrapround_string(s: String) -> i32 {
        

        let mut dp = vec![0; 26];
        let mut count = 0;
        let s = s.as_bytes();
        for i in 0..s.len() {
            if i > 0 && (s[i] as i32 - s[i - 1] as i32 == 1 || s[i - 1] as i32 - s[i] as i32 == 25) {
                count += 1;
            } else {
                count = 1;
            }
            let index = (s[i] - b'a') as usize;
            dp[index] = dp[index].max(count);
        }
        dp.iter().sum()
    }
}