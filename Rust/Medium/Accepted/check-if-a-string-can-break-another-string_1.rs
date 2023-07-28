impl Solution {
    pub fn check_if_can_break(s1: String, s2: String) -> bool {
        
        let mut s1 = s1.into_bytes();
        let mut s2 = s2.into_bytes();
        s1.sort();
        s2.sort();
        let (mut i, mut j) = (0, 0);
        let (mut n1, mut n2) = (0, 0);
        for k in 0..s1.len() {
            if s1[k] > s2[k] {
                n1 += 1;
            } else if s1[k] < s2[k] {
                n2 += 1;
            }
        }
        n1 == 0 || n2 == 0
    }
}