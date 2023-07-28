impl Solution {
    pub fn are_occurrences_equal(s: String) -> bool {
        
        let mut c = [0; 26];
        for b in s.as_bytes() {
            c[(b - b'a') as usize] += 1;
        }
        let mut count = 0;
        for i in 0..26 {
            if c[i] > 0 {
                if count == 0 {
                    count = c[i];
                } else if count != c[i] {
                    return false;
                }
            }
        }
        true
    }
}