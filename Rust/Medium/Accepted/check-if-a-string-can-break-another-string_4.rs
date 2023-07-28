impl Solution {
    pub fn check_if_can_break(s1: String, s2: String) -> bool {
        
        let mut s1 = s1.chars().collect::<Vec<char>>();
        let mut s2 = s2.chars().collect::<Vec<char>>();
        s1.sort();
        s2.sort();
        let mut s1_bigger = true;
        let mut s2_bigger = true;
        for i in 0..s1.len() {
            if s1[i] < s2[i] {
                s1_bigger = false;
            }
            if s2[i] < s1[i] {
                s2_bigger = false;
            }
        }
        s1_bigger || s2_bigger
    }
}