impl Solution {
    pub fn find_substring_in_wrapround_string(s: String) -> i32 {
        

        let mut dp = vec![0; 26];
        let mut max = 0;
        for (i, ch) in s.chars().enumerate() {
            let cur = ch as u8 - 'a' as u8;
            if i > 0 && (cur + 1) % 26 != (s[i - 1] as u8 - 'a' as u8) {
                max = 0;
            }
            max += 1;
            dp[cur as usize] = dp[cur as usize].max(max);
        }
        dp.iter().sum()
    }
}