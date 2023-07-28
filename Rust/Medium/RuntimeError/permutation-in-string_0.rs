impl Solution {
    pub fn check_inclusion(s1: String, s2: String) -> bool {
        

        let mut s1 = s1.as_bytes().to_vec();
        let mut s2 = s2.as_bytes().to_vec();
        s1.sort();
        for i in 0..=s2.len()-s1.len() {
            let mut s = s2[i..i+s1.len()].to_vec();
            s.sort();
            if s == s1 {
                return true;
            }
        }
        false
    }
}