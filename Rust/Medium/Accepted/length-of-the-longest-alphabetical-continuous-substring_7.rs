impl Solution {
    pub fn longest_continuous_substring(s: String) -> i32 {
        
        let mut max = 0;
        let mut cur = 0;
        let mut last = 0;
        for c in s.chars() {
            if c as i32 - last == 1 {
                cur += 1;
            } else {
                max = max.max(cur);
                cur = 1;
            }
            last = c as i32;
        }
        max.max(cur)
    }
}