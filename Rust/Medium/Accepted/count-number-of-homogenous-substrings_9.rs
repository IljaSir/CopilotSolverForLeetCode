impl Solution {
    pub fn count_homogenous(s: String) -> i32 {
        
        let mut res = 0;
        let mut cur = 1;
        let mut last = 0;
        let mut last_char = ' ';
        for c in s.chars() {
            if c == last_char {
                cur += 1;
            } else {
                cur = 1;
                last_char = c;
            }
            res += cur;
            res %= 1_000_000_007;
        }
        res
    }
}