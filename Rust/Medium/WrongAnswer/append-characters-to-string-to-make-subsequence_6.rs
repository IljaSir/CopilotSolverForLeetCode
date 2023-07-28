impl Solution {
    pub fn append_characters(s: String, t: String) -> i32 {
        
        let mut i: usize = 0;
        let mut j: usize = 0;
        let mut ans: i32 = 0;
        let s = s.into_bytes();
        let t = t.into_bytes();
        while i < s.len() {
            if s[i] == t[j] {
                j += 1;
                if j == t.len() {
                    break;
                }
            }
            i += 1;
        }
        if j == t.len() {
            ans = (s.len() - i) as i32;
        } else {
            ans = (s.len() + t.len() - i - j) as i32;
        }
        ans
    }
}