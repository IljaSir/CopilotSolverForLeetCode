impl Solution {
    pub fn are_almost_equal(s1: String, s2: String) -> bool {
        
        let mut s1 = s1.into_bytes();
        let mut s2 = s2.into_bytes();
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
        s1.swap(i, j);
        s1 == s2
    }
}