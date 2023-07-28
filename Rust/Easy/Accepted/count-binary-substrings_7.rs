impl Solution {
    pub fn count_binary_substrings(s: String) -> i32 {
        
        let mut count = 0;
        let mut last = 0;
        let mut cur = 1;
        let mut chars = s.chars();
        let mut last_char = chars.next().unwrap();
        for c in chars {
            if c == last_char {
                cur += 1;
            } else {
                count += std::cmp::min(cur, last);
                last = cur;
                cur = 1;
                last_char = c;
            }
        }
        count + std::cmp::min(cur, last)
    }
}