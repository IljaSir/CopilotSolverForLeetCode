impl Solution {
    pub fn check_inclusion(s1: String, s2: String) -> bool {
        

        let mut s1 = s1.into_bytes();
        let mut s2 = s2.into_bytes();
        let mut s1_count = [0; 26];
        let mut s2_count = [0; 26];
        for i in 0..s1.len() {
            s1_count[s1[i] as usize - 97] += 1;
            s2_count[s2[i] as usize - 97] += 1;
        }
        if s1_count == s2_count {
            return true;
        }
        for i in 0..s2.len() - s1.len() {
            s2_count[s2[i] as usize - 97] -= 1;
            s2_count[s2[i + s1.len()] as usize - 97] += 1;
            if s1_count == s2_count {
                return true;
            }
        }
        false
    }
}