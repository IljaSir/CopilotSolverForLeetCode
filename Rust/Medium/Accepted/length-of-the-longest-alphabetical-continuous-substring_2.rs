impl Solution {
    pub fn longest_continuous_substring(s: String) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        let mut prev = ' ';
        for c in s.chars() {
            if c as u8 - prev as u8 == 1 {
                count += 1;
            } else {
                count = 1;
            }
            max = max.max(count);
            prev = c;
        }
        max
    }
}