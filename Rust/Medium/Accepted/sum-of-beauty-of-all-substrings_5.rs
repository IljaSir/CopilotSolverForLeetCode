impl Solution {
    pub fn beauty_sum(s: String) -> i32 {
        
        let mut ans = 0;
        let n = s.len();
        for i in 0..n {
            let mut freq = [0; 26];
            for j in i..n {
                let c = s.as_bytes()[j] as usize - b'a' as usize;
                freq[c] += 1;
                let mut min = i32::MAX;
                let mut max = i32::MIN;
                for &x in freq.iter() {
                    if x > 0 {
                        min = min.min(x as i32);
                        max = max.max(x as i32);
                    }
                }
                ans += max - min;
            }
        }
        ans
    }
}