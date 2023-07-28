impl Solution {
    pub fn are_occurrences_equal(s: String) -> bool {
        
        let mut count = [0; 26];
        for c in s.chars() {
            count[(c as u8 - 'a' as u8) as usize] += 1;
        }
        let mut prev = 0;
        for i in 0..26 {
            if count[i] > 0 {
                if prev == 0 {
                    prev = count[i];
                } else if prev != count[i] {
                    return false;
                }
            }
        }
        true
    }
}