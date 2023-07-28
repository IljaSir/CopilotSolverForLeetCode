impl Solution {
    pub fn minimum_time(s: String) -> i32 {
        
        let mut ans = 0;
        let mut cnt = 0;
        for c in s.chars() {
            if c == '1' {
                cnt += 1;
            } else {
                ans += cnt / 2;
                cnt = 0;
            }
        }
        ans += cnt / 2;
        ans * 2 + cnt % 2
    }
}