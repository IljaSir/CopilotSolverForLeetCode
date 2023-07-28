impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let mut cnt = 0;
        for c in s.chars() {
            if c == '[' {
                cnt += 1;
            } else {
                cnt -= 1;
            }
            if cnt < 0 {
                cnt += 2;
            }
        }
        cnt / 2
    }
}