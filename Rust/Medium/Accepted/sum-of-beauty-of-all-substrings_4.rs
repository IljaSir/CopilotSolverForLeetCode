impl Solution {
    pub fn beauty_sum(s: String) -> i32 {
        
        let mut ans = 0;
        let mut cnt = vec![0; 26];
        for i in 0..s.len() {
            for j in 0..26 {
                cnt[j] = 0;
            }
            for j in i..s.len() {
                cnt[(s.as_bytes()[j] - b'a') as usize] += 1;
                let mut min = 501;
                let mut max = -1;
                for k in 0..26 {
                    if cnt[k] > 0 {
                        min = min.min(cnt[k]);
                        max = max.max(cnt[k]);
                    }
                }
                ans += max - min;
            }
        }
        ans
    }
}