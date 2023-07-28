impl Solution {
    pub fn num_sub(s: String) -> i32 {
        
        let mut res = 0;
        let mut cnt = 0;
        for c in s.chars() {
            if c == '0' {
                cnt = 0;
            } else {
                cnt += 1;
                res = (res + cnt) % 1_000_000_007;
            }
        }
        res
    }
}