impl Solution {
    pub fn max_power(s: String) -> i32 {
        
        let mut max = 0;
        let mut cur = 1;
        let mut prev = ' ';
        for c in s.chars() {
            if c == prev {
                cur += 1;
            } else {
                cur = 1;
            }
            max = max.max(cur);
            prev = c;
        }
        max
    }
}