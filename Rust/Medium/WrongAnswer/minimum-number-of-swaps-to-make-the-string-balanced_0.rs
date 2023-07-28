impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let mut cnt = 0;
        let mut ans = 0;
        for c in s.chars() {
            if c == '[' {
                cnt += 1;
            } else {
                if cnt > 0 {
                    cnt -= 1;
                } else {
                    ans += 1;
                }
            }
        }
        ans
    }
}