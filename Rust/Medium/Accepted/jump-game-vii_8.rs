impl Solution {
    pub fn can_reach(s: String, min_jump: i32, max_jump: i32) -> bool {
        
        let s = s.into_bytes();
        let n = s.len();
        let mut can = vec![false; n];
        let mut reach = 0;
        can[0] = true;
        for i in 1..n {
            if i >= min_jump as usize {
                reach += can[i - min_jump as usize] as i32;
            }
            if i > max_jump as usize {
                reach -= can[i - max_jump as usize - 1] as i32;
            }
            can[i] = reach > 0 && s[i] == b'0';
        }
        can[n - 1]
    }
}