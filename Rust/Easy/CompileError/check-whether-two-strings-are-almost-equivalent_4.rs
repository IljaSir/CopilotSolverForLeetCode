impl Solution {
    pub fn check_almost_equivalent(word1: String, word2: String) -> bool {
        
        let mut c1 = [0; 26];
        let mut c2 = [0; 26];
        for c in word1.chars() {
            c1[c as usize - 97] += 1;
        }
        for c in word2.chars() {
            c2[c as usize - 97] += 1;
        }
        let mut diff = 0;
        for i in 0..26 {
            diff += (c1[i] - c2[i]).abs();
            if diff > 6 {
                return false;
            }
        }
        true
    }
}