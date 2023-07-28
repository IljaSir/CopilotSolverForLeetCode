impl Solution {
    pub fn beauty_sum(s: String) -> i32 {
        
        let mut res = 0;
        let s = s.as_bytes();
        for i in 0..s.len() {
            let mut cnt = [0; 26];
            for j in i..s.len() {
                let idx = (s[j] - b'a') as usize;
                cnt[idx] += 1;
                res += Self::max(&cnt) - Self::min(&cnt);
            }
        }
        res
    }
    fn max(cnt: &[i32]) -> i32 {
        cnt.iter().filter(|&x| *x != 0).max().unwrap()
    }
}