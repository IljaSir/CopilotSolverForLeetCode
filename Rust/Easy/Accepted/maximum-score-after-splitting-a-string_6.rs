impl Solution {
    pub fn max_score(s: String) -> i32 {
        
        let mut s = s.into_bytes();
        let mut one = 0;
        let mut zero = 0;
        for i in 0..s.len() {
            if s[i] == b'1' {
                one += 1;
            }
        }
        let mut max = 0;
        for i in 0..s.len() - 1 {
            if s[i] == b'1' {
                one -= 1;
            } else {
                zero += 1;
            }
            if one + zero > max {
                max = one + zero;
            }
        }
        max
    }
}