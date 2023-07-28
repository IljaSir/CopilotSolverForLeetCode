impl Solution {
    pub fn are_almost_equal(s1: String, s2: String) -> bool {
        
        let mut count = 0;
        let mut s1 = s1.into_bytes();
        let mut s2 = s2.into_bytes();
        for i in 0..s1.len() {
            if s1[i] != s2[i] {
                count += 1;
                if count > 2 {
                    return false;
                }
                for j in i+1..s1.len() {
                    if s1[i] == s1[j] && s2[i] == s2[j] {
                        s1.swap(i, j);
                        break;
                    }
                    if s1[i] == s2[j] && s2[i] == s1[j] {
                        s1.swap(i, j);
                        s2.swap(i, j);
                        break;
                    }
                }
            }
        }
        s1 == s2
    }
}