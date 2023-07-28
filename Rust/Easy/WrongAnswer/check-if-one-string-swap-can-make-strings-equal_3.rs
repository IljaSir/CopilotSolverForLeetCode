impl Solution {
    pub fn are_almost_equal(s1: String, s2: String) -> bool {
        
        if s1 == s2 {
            return true;
        }
        let mut s1 = s1.chars().collect::<Vec<char>>();
        let mut s2 = s2.chars().collect::<Vec<char>>();
        let mut diff = 0;
        let mut diff1 = 0;
        let mut diff2 = 0;
        for i in 0..s1.len() {
            if s1[i] != s2[i] {
                diff += 1;
                diff1 = i;
            }
        }
        if diff != 2 {
            return false;
        }
        for i in 0..s1.len() {
            if s1[i] != s2[i] {
                diff2 = i;
            }
        }
        s1.swap(diff1, diff2);
        s1 == s2
    }
}