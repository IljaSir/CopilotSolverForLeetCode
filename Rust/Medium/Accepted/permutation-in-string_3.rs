impl Solution {
    pub fn check_inclusion(s1: String, s2: String) -> bool {
        

        let mut s1 = s1.as_bytes().to_vec();
        let s2 = s2.as_bytes();
        s1.sort();
        for i in 0..s2.len() {
            if i + s1.len() > s2.len() {
                break;
            }
            let mut tmp = s2[i..i+s1.len()].to_vec();
            tmp.sort();
            if tmp == s1 {
                return true;
            }
        }
        false
    }
}