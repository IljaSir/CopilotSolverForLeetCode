impl Solution {
    pub fn character_replacement(s: String, k: i32) -> i32 {
        

        let mut max_cnt = 0;
        let mut start = 0;
        let mut cnt = vec![0; 26];
        let mut res = 0;
        let s: Vec<char> = s.chars().collect();
        for end in 0..s.len() {
            max_cnt = max_cnt.max(++cnt[s[end] as usize - 65]);
            while end - start + 1 - max_cnt > k as usize {
                cnt[s[start] as usize - 65] -= 1;
                start += 1;
            }
            res = res.max(end - start + 1);
        }
        res as i32
    }
}