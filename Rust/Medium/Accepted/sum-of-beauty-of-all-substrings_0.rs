impl Solution {
    pub fn beauty_sum(s: String) -> i32 {
        
        let mut ans = 0;
        let s = s.as_bytes();
        for i in 0..s.len() {
            let mut cnt = [0; 26];
            for j in i..s.len() {
                cnt[(s[j] - b'a') as usize] += 1;
                let mut max = 0;
                let mut min = 500;
                for &c in cnt.iter() {
                    if c > 0 {
                        max = max.max(c);
                        min = min.min(c);
                    }
                }
                ans += max - min;
            }
        }
        ans
    }
}