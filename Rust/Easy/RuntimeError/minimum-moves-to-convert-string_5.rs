impl Solution {
    pub fn minimum_moves(s: String) -> i32 {
        
        let mut res = 0;
        let mut s = s.into_bytes();
        let n = s.len();
        for i in 0..n {
            if s[i] == b'X' {
                res += 1;
                for j in i..i+3 {
                    s[j] = b'O';
                }
            }
        }
        res
    }
}