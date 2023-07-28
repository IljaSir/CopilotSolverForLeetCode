impl Solution {
    pub fn longest_continuous_substring(s: String) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        let mut last = 'a';
        for c in s.chars() {
            if c >= last {
                count += 1;
            } else {
                count = 1;
            }
            max = max.max(count);
            last = c;
        }
        max
    }
}