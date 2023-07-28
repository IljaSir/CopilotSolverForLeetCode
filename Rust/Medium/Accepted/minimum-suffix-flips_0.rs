impl Solution {
    pub fn min_flips(target: String) -> i32 {
        
        let mut ans = 0;
        let mut last = '0';
        for c in target.chars() {
            if c != last {
                ans += 1;
                last = c;
            }
        }
        ans
    }
}