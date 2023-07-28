impl Solution {
    pub fn character_replacement(s: String, k: i32) -> i32 {
        

        let s = s.as_bytes();
        let mut max_cnt = 0;
        let mut max_len = 0;
        let mut l = 0;
        let mut r = 0;
        let mut cnt = vec![0; 26];
        while r < s.len() {
            let idx = (s[r] - b'A') as usize;
            cnt[idx] += 1;
            max_cnt = max_cnt.max(cnt[idx]);
            while r - l + 1 - max_cnt > k as usize {
                cnt[(s[l] - b'A') as usize] -= 1;
                l += 1;
            }
            max_len = max_len.max(r - l + 1);
            r += 1;
        }
        max_len as i32
    }
}