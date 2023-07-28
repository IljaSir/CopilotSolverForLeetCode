impl Solution {
    pub fn appeal_sum(s: String) -> i64 {
        
        let s = s.as_bytes();
        let mut cnt = [0; 26];
        let mut ans = 0;
        for (i, &c) in s.iter().enumerate() {
            let j = (c - b'a') as usize;
            cnt[j] += 1;
            let mut sum = 0;
            for &c in &cnt {
                if c > 0 {
                    sum += 1;
                }
            }
            ans += sum * (i + 1) as i64;
        }
        ans
    }
}