impl Solution {
    pub fn check_if_can_break(s1: String, s2: String) -> bool {
        
        let mut s1 = s1.into_bytes();
        let mut s2 = s2.into_bytes();
        s1.sort();
        s2.sort();
        let mut i = 0;
        while i < s1.len() {
            if s1[i] < s2[i] {
                break;
            }
            i += 1;
        }
        if i == s1.len() {
            return true;
        }
        i = 0;
        while i < s1.len() {
            if s1[i] > s2[i] {
                break;
            }
            i += 1;
        }
        if i == s1.len() {
            return true;
        }
        false
    }
}