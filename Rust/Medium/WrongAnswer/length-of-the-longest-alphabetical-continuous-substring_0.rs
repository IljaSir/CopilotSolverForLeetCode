impl Solution {
    pub fn longest_continuous_substring(s: String) -> i32 {
        
        let mut max = 1;
        let mut count = 1;
        let s = s.as_bytes();
        for i in 1..s.len() {
            if s[i] > s[i - 1] {
                count += 1;
            } else {
                count = 1;
            }
            max = std::cmp::max(max, count);
        }
        max
    }
}