impl Solution {
    pub fn longest_continuous_substring(s: String) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        let mut prev = 0;
        for c in s.chars() {
            let cur = c as u8 - 'a' as u8;
            if cur == prev + 1 {
                count += 1;
            } else {
                count = 1;
            }
            prev = cur;
            if count > max {
                max = count;
            }
        }
        max
    }
}