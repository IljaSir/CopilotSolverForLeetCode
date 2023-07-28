impl Solution {
    pub fn minimum_moves(s: String) -> i32 {
        
        let mut cnt = 0;
        let mut i = 0;
        let bytes = s.as_bytes();
        while i < bytes.len() {
            if bytes[i] == b'X' {
                cnt += 1;
                i += 3;
            } else {
                i += 1;
            }
        }
        cnt
    }
}