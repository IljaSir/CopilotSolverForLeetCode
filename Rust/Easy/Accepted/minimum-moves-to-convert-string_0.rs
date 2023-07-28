impl Solution {
    pub fn minimum_moves(s: String) -> i32 {
        
        let s = s.as_bytes();
        let mut i = 0;
        let mut res = 0;
        while i < s.len() {
            if s[i] == b'X' {
                res += 1;
                i += 3;
            } else {
                i += 1;
            }
        }
        res
    }
}