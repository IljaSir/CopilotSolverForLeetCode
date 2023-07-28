impl Solution {
    pub fn are_occurrences_equal(s: String) -> bool {
        
        let mut count = [0; 26];
        for ch in s.chars() {
            count[(ch as u8 - 'a' as u8) as usize] += 1;
        }
        let mut first = 0;
        for i in 0..26 {
            if count[i] > 0 {
                first = count[i];
                break;
            }
        }
        for i in 0..26 {
            if count[i] > 0 && count[i] != first {
                return false;
            }
        }
        true
    }
}