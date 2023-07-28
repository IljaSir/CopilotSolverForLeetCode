impl Solution {
    pub fn check_if_can_break(s1: String, s2: String) -> bool {
        
        let mut s1 = s1.into_bytes();
        let mut s2 = s2.into_bytes();
        s1.sort();
        s2.sort();
        let mut s1b = true;
        let mut s2b = true;
        for i in 0..s1.len() {
            if s1[i] < s2[i] {
                s1b = false;
            }
            if s2[i] < s1[i] {
                s2b = false;
            }
        }
        s1b || s2b
    }
}