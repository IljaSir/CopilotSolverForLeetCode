impl Solution {
    pub fn longest_continuous_substring(s: String) -> i32 {
        
        let mut max = 0;
        let mut cur = 0;
        let mut last = ' ';
        for c in s.chars() {
            if c > last {
                cur += 1;
            } else {
                max = max.max(cur);
                cur = 1;
            }
            last = c;
        }
        max.max(cur)
    }
}