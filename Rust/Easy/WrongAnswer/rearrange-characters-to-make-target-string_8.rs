impl Solution {
    pub fn rearrange_characters(s: String, target: String) -> i32 {
        
        let mut s = s.into_bytes();
        let mut target = target.into_bytes();
        let mut res = 0;
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        s.sort();
        target.sort();
        while i < s.len() && j < target.len() {
            if s[i] == target[j] {
                i += 1;
                j += 1;
            } else {
                i += 1;
            }
        }
        if j == target.len() {
            res = 1;
            k = i;
            while i < s.len() {
                if s[i] == s[k] {
                    res += 1;
                } else {
                    break;
                }
                i += 1;
            }
        }
        res
    }
}