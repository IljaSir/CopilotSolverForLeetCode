impl Solution {
    pub fn rearrange_characters(s: String, target: String) -> i32 {
        
        let mut s = s.into_bytes();
        s.sort();
        let mut target = target.into_bytes();
        target.sort();
        let mut i = 0;
        let mut j = 0;
        while i < s.len() && j < target.len() {
            if s[i] == target[j] {
                i += 1;
                j += 1;
            } else {
                i += 1;
            }
        }
        if j == target.len() {
            1
        } else {
            0
        }
    }
}