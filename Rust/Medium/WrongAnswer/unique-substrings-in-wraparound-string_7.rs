impl Solution {
    pub fn find_substring_in_wrapround_string(s: String) -> i32 {
        

        let mut v = vec![0; 26];
        let mut cnt = 0;
        let mut s = s.chars().map(|c| (c as u8 - b'a') as usize).collect::<Vec<_>>();
        s.push(26);
        for i in 0..s.len() - 1 {
            if s[i] + 1 == s[i + 1] {
                cnt += 1;
            } else {
                cnt = 1;
            }
            v[s[i]] = v[s[i]].max(cnt);
        }
        v.into_iter().sum()
    }
}