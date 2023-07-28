impl Solution {
    pub fn check_if_can_break(s1: String, s2: String) -> bool {
        
        let mut s1 = s1.chars().collect::<Vec<_>>();
        let mut s2 = s2.chars().collect::<Vec<_>>();
        s1.sort();
        s2.sort();
        let mut s1_break = true;
        let mut s2_break = true;
        for i in 0..s1.len() {
            if s1[i] < s2[i] {
                s1_break = false;
            }
            if s1[i] > s2[i] {
                s2_break = false;
            }
        }
        s1_break || s2_break
    }
}