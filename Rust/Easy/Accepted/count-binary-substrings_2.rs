impl Solution {
    pub fn count_binary_substrings(s: String) -> i32 {
        
        let mut count = 0;
        let mut prev = 0;
        let mut cur = 1;
        for i in 1..s.len() {
            if s.as_bytes()[i] == s.as_bytes()[i-1] {
                cur += 1;
            } else {
                count += std::cmp::min(prev, cur);
                prev = cur;
                cur = 1;
            }
        }
        count + std::cmp::min(prev, cur)
    }
}