impl Solution {
    pub fn minimum_moves(s: String) -> i32 {
        
        let mut s = s.into_bytes();
        let mut ans = 0;
        for i in 0..s.len() {
            if s[i] == b'X' {
                ans += 1;
                s[i] = b'O';
                if i + 1 < s.len() {
                    s[i + 1] = b'O';
                }
                if i + 2 < s.len() {
                    s[i + 2] = b'O';
                }
            }
        }
        ans
    }
}