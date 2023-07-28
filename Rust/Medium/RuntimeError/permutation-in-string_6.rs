impl Solution {
    pub fn check_inclusion(s1: String, s2: String) -> bool {
        

        let mut s1 = s1.into_bytes();
        let mut s2 = s2.into_bytes();
        s1.sort();
        for i in 0..=s2.len()-s1.len() {
            let mut s2_sub = s2[i..i+s1.len()].to_vec();
            s2_sub.sort();
            if s2_sub == s1 {
                return true;
            }
        }
        false
    }
}