impl Solution {
    pub fn can_convert_string(s: String, t: String, k: i32) -> bool {
        
        let s = s.as_bytes();
        let t = t.as_bytes();
        if s.len() != t.len() {
            return false;
        }
        let mut cnt = vec![0; 26];
        for i in 0..s.len() {
            let diff = if t[i] >= s[i] { t[i] - s[i] } else { 26 - s[i] + t[i] };
            if diff > 0 {
                cnt[diff as usize] += 1;
            }
        }
        for i in 1..cnt.len() {
            if cnt[i] * i as i32 > k {
                return false;
            }
        }
        true
    }
}