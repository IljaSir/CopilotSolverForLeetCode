impl Solution {
    pub fn find_substring_in_wrapround_string(s: String) -> i32 {
        

        let mut s = s.into_bytes();
        let mut cnt = vec![0; 26];
        let mut max = 0;
        for i in 0..s.len() {
            let c = s[i];
            if i > 0 && (c as i8 - s[i-1] as i8).abs() != 1 && c != b'a' || i == 0 && c != b'a' {
                max = 0;
            }
            max += 1;
            let idx = (c - b'a') as usize;
            cnt[idx] = cnt[idx].max(max);
        }
        cnt.iter().sum()
    }
}