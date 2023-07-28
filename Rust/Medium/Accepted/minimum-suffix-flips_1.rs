impl Solution {
    pub fn min_flips(target: String) -> i32 {
        
        let mut ans = 0;
        let mut cur = '0';
        for c in target.chars() {
            if c != cur {
                ans += 1;
                cur = c;
            }
        }
        ans
    }
}