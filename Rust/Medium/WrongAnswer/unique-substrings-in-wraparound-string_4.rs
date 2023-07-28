impl Solution {
    pub fn find_substring_in_wrapround_string(s: String) -> i32 {
        

        let mut cnt = vec![0; 26];
        let mut max_len = 0;
        for (i, c) in s.chars().enumerate() {
            let n = c as usize - 'a' as usize;
            if i > 0 && (s.as_bytes()[i] as i32 - s.as_bytes()[i - 1] as i32).abs() != 1 {
                max_len = 0;
            }
            max_len += 1;
            cnt[n] = cnt[n].max(max_len);
        }
        cnt.iter().sum()
    }
}