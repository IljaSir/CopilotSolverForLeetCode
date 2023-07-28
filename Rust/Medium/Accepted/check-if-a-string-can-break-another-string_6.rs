impl Solution {
    pub fn check_if_can_break(s1: String, s2: String) -> bool {
        
        let mut s1 = s1.into_bytes();
        let mut s2 = s2.into_bytes();
        s1.sort();
        s2.sort();
        let mut s1_bigger = false;
        let mut s2_bigger = false;
        for i in 0..s1.len() {
            if s1[i] > s2[i] {
                if s2_bigger {
                    return false;
                }
                s1_bigger = true;
            } else if s1[i] < s2[i] {
                if s1_bigger {
                    return false;
                }
                s2_bigger = true;
            }
        }
        true
    }
}