impl Solution {
    pub fn count_binary_substrings(s: String) -> i32 {
        
        let mut count = 0;
        let mut prev = 0;
        let mut cur = 1;
        for i in 0..s.len() - 1 {
            if s.chars().nth(i) == s.chars().nth(i + 1) {
                cur += 1;
            } else {
                prev = cur;
                cur = 1;
            }
            if prev >= cur {
                count += 1;
            }
        }
        count
    }
}