impl Solution {
    pub fn can_convert_string(s: String, t: String, k: i32) -> bool {
        
        if s.len() != t.len() {
            return false;
        }
        let mut arr = vec![0; 26];
        for (i, c) in s.chars().enumerate() {
            let offset = (t.chars().nth(i).unwrap() as i32 - c as i32 + 26) % 26;
            if offset != 0 {
                arr[offset as usize] += 1;
            }
        }
        for i in 1..26 {
            if arr[i] > (k - i) / 26 + 1 {
                return false;
            }
        }
        true
    }
}