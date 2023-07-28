impl Solution {
    pub fn max_power(s: String) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        let mut prev = ' ';
        for c in s.chars() {
            if c == prev {
                count += 1;
            } else {
                max = max.max(count);
                count = 1;
                prev = c;
            }
        }
        max.max(count)
    }
}