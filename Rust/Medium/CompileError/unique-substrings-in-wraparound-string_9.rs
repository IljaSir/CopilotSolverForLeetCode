impl Solution {
    pub fn find_substring_in_wrapround_string(s: String) -> i32 {
        

        let mut dp = vec![0; 26];
        let mut count = 0;
        let mut prev = -1;
        for ch in s.chars() {
            let ch = ch as usize - 'a' as usize;
            if prev + 1 == ch || (prev == 25 && ch == 0) {
                count += 1;
            } else {
                count = 1;
            }
            dp[ch] = dp[ch].max(count);
            prev = ch as i32;
        }
        dp.iter().sum()
    }
}