impl Solution {
    pub fn are_occurrences_equal(s: String) -> bool {
        
        let mut chars = [0; 26];
        for c in s.chars() {
            chars[c as usize - 'a' as usize] += 1;
        }
        let mut count = 0;
        for i in 0..26 {
            if chars[i] != 0 {
                if count == 0 {
                    count = chars[i];
                } else if count != chars[i] {
                    return false;
                }
            }
        }
        true
    }
}