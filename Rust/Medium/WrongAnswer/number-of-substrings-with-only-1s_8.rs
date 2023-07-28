impl Solution {
    pub fn num_sub(s: String) -> i32 {
        
        let mut ans = 0;
        let mut cur = 0;
        for c in s.chars() {
            if c == '1' {
                cur += 1;
            } else {
                ans = (ans + cur * (cur + 1) / 2) % 1000000007;
                cur = 0;
            }
        }
        ans = (ans + cur * (cur + 1) / 2) % 1000000007;
        ans
    }
}