impl Solution {
    pub fn check_if_can_break(s1: String, s2: String) -> bool {
        
        let mut s1 = s1.as_bytes().to_vec();
        let mut s2 = s2.as_bytes().to_vec();
        s1.sort();
        s2.sort();
        let mut s1_bigger = true;
        let mut s2_bigger = true;
        for i in 0..s1.len() {
            if s1[i] > s2[i] {
                s2_bigger = false;
            }
            if s1[i] < s2[i] {
                s1_bigger = false;
            }
        }
        s1_bigger || s2_bigger
    }
}