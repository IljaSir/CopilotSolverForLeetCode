impl Solution {
    pub fn max_length_between_equal_characters(s: String) -> i32 {
        
        let mut i = 0;
        let mut j = s.len() - 1;
        let mut max = -1;
        while i < j {
            if s.chars().nth(i).unwrap() == s.chars().nth(j).unwrap() {
                max = max.max((j - i - 1) as i32);
                i += 1;
                j -= 1;
            } else {
                i += 1;
                j -= 1;
            }
        }
        max
    }
}