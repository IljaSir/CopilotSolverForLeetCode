impl Solution {
    pub fn can_convert_string(s: String, t: String, k: i32) -> bool {
        
        if s.len() != t.len() {
            return false;
        }
        let mut count = vec![0; 26];
        for (i, c) in s.chars().enumerate() {
            let diff = (t.chars().nth(i).unwrap() as i32 - c as i32 + 26) % 26;
            if diff > 0 {
                count[diff as usize] += 1;
            }
        }
        for i in 1..26 {
            if count[i] > (k as f32 / 26.0).ceil() as i32 {
                return false;
            }
        }
        true
    }
}