impl Solution {
    pub fn can_convert_string(s: String, t: String, k: i32) -> bool {
        
        let s = s.as_bytes();
        let t = t.as_bytes();
        let k = k as usize;
        if s.len() != t.len() {
            return false;
        }
        let mut count = vec![0; 26];
        for i in 0..s.len() {
            let diff = (t[i] as i32 - s[i] as i32 + 26) % 26;
            if diff > 0 {
                count[diff as usize] += 1;
            }
        }
        for i in 1..26 {
            if count[i] * 26 + i > k {
                return false;
            }
        }
        true
    }
}