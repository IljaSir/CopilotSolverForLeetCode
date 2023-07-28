impl Solution {
    pub fn are_occurrences_equal(s: String) -> bool {
        
        let mut s = s.into_bytes();
        s.sort();
        let mut count = 1;
        let mut prev = s[0];
        for i in 1..s.len() {
            if s[i] == prev {
                count += 1;
            } else {
                if count != s.len()/26 {
                    return false;
                }
                prev = s[i];
                count = 1;
            }
        }
        count == s.len()/26
    }
}