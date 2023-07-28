impl Solution {
    pub fn rearrange_characters(s: String, target: String) -> i32 {
        
        let mut s = s.into_bytes();
        let mut target = target.into_bytes();
        s.sort_unstable();
        target.sort_unstable();
        let mut i = 0;
        for j in 0..s.len() {
            if i < target.len() && s[j] == target[i] {
                i += 1;
            }
        }
        if i == target.len() {
            1
        } else {
            0
        }
    }
}