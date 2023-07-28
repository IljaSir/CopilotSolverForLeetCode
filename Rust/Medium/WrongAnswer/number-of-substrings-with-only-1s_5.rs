impl Solution {
    pub fn num_sub(s: String) -> i32 {
        
        let mut res = 0;
        let mut cnt = 0;
        for c in s.chars() {
            if c == '1' {
                cnt += 1;
                res += cnt;
            } else {
                cnt = 0;
            }
        }
        res as i32 % 1000000007
    }
}