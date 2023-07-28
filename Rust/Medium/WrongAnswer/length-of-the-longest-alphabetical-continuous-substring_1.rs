impl Solution {
    pub fn longest_continuous_substring(s: String) -> i32 {
        
        let mut max = 0;
        let mut cur = 0;
        for i in 1..s.len() {
            if s.as_bytes()[i] > s.as_bytes()[i - 1] {
                cur += 1;
            } else {
                cur = 0;
            }
            if cur > max {
                max = cur;
            }
        }
        max + 1
    }
}