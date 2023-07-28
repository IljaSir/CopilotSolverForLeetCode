impl Solution {
    pub fn minimum_score(s: String, t: String) -> i32 {
        
        let mut s = s.as_bytes();
        let mut t = t.as_bytes();
        let mut l = 0;
        let mut r = t.len() - 1;
        while l < r {
            if t[l] == s[l] {
                l += 1;
            } else if t[r] == s[r] {
                r -= 1;
            } else {
                break;
            }
        }
        if l >= r {
            0
        } else {
            (r - l + 1) as i32
        }
    }
}