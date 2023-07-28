impl Solution {
    pub fn are_almost_equal(s1: String, s2: String) -> bool {
        
        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        let mut diff = Vec::new();
        for i in 0..s1.len() {
            if s1[i] != s2[i] {
                diff.push(i);
            }
        }
        if diff.len() == 0 {
            return true;
        }
        if diff.len() != 2 {
            return false;
        }
        let i = diff[0];
        let j = diff[1];
        s1[i] == s2[j] && s2[i] == s1[j]
    }
}