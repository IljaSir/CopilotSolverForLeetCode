impl Solution {
    pub fn are_almost_equal(s1: String, s2: String) -> bool {
        
        let mut s1 = s1.chars().collect::<Vec<char>>();
        let mut s2 = s2.chars().collect::<Vec<char>>();
        let mut diff = 0;
        for i in 0..s1.len() {
            if s1[i] != s2[i] {
                diff += 1;
            }
        }
        if diff > 2 {
            return false;
        }
        s1.sort();
        s2.sort();
        s1 == s2
    }
}