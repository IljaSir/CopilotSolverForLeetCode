impl Solution {
    pub fn are_occurrences_equal(s: String) -> bool {
        
        let mut count = [0; 26];
        for c in s.chars() {
            count[c as usize - 'a' as usize] += 1;
        }
        let mut first = 0;
        for i in 0..26 {
            if count[i] == 0 {
                continue;
            }
            if first == 0 {
                first = count[i];
            } else if count[i] != first {
                return false;
            }
        }
        true
    }
}