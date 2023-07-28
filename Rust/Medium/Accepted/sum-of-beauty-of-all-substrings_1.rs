impl Solution {
    pub fn beauty_sum(s: String) -> i32 {
        
        let mut ans = 0;
        let s = s.as_bytes();
        for i in 0..s.len() {
            let mut cnt = vec![0; 26];
            for j in i..s.len() {
                cnt[(s[j] - b'a') as usize] += 1;
                let mut min = 501;
                let mut max = 0;
                for &c in &cnt {
                    if c > 0 {
                        min = min.min(c);
                        max = max.max(c);
                    }
                }
                ans += max - min;
            }
        }
        ans
    }
}