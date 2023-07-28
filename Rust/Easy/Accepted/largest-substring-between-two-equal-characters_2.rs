impl Solution {
    pub fn max_length_between_equal_characters(s: String) -> i32 {
        
        let mut max = -1;
        let mut i = 0;
        while i < s.len() {
            let mut j = i + 1;
            while j < s.len() {
                if s.chars().nth(i) == s.chars().nth(j) {
                    max = max.max((j - i - 1) as i32);
                }
                j += 1;
            }
            i += 1;
        }
        max
    }
}