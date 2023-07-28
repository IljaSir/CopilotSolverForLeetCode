impl Solution {
    pub fn can_convert_string(s: String, t: String, k: i32) -> bool {
        
        let k = k as usize;
        let s = s.as_bytes();
        let t = t.as_bytes();
        if s.len() != t.len() {
            return false;
        }
        let mut cnt = vec![0; 26];
        for i in 0..s.len() {
            let d = if t[i] >= s[i] { t[i] - s[i] } else { 26 - s[i] + t[i] };
            if d > 0 {
                cnt[d as usize] += 1;
            }
        }
        for i in 1..26 {
            if cnt[i] > (k + i) / 26 {
                return false;
            }
        }
        true
    }
}