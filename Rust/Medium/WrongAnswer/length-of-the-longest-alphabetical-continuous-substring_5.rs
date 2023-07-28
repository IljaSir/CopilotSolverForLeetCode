impl Solution {
    pub fn longest_continuous_substring(s: String) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        let mut prev = 'a';
        for c in s.chars() {
            if c >= prev {
                count += 1;
                max = std::cmp::max(max, count);
            } else {
                count = 1;
            }
            prev = c;
        }
        max
    }
}