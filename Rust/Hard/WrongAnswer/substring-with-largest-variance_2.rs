impl Solution {
    pub fn largest_variance(s: String) -> i32 {
        
        let mut ans = 0;
        let mut cnt = vec![0; 26];
        let mut s = s.chars().collect::<Vec<char>>();
        for i in 0..s.len() {
            for j in i..s.len() {
                let idx = (s[j] as u8 - b'a') as usize;
                cnt[idx] += 1;
                let mut max = 0;
                let mut min = s.len();
                for k in 0..26 {
                    max = max.max(cnt[k]);
                    min = min.min(cnt[k]);
                }
                ans = ans.max(max - min);
            }
            for j in i..s.len() {
                let idx = (s[j] as u8 - b'a') as usize;
                cnt[idx] -= 1;
            }
        }
        ans as i32
    }
}