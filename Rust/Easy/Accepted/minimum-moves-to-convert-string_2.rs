impl Solution {
    pub fn minimum_moves(s: String) -> i32 {
        
        let mut cnt = 0;
        let mut i = 0;
        let s = s.as_bytes();
        while i < s.len() {
            if s[i] == b'X' {
                cnt += 1;
                i += 3;
            } else {
                i += 1;
            }
        }
        cnt
    }
}