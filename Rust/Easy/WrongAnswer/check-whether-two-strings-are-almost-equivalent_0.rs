impl Solution {
    pub fn check_almost_equivalent(word1: String, word2: String) -> bool {
        
        let mut v1 = vec![0; 26];
        let mut v2 = vec![0; 26];
        for c in word1.chars() {
            v1[c as usize - 'a' as usize] += 1;
        }
        for c in word2.chars() {
            v2[c as usize - 'a' as usize] += 1;
        }
        let mut diff = 0;
        for i in 0..26 {
            if v1[i] != v2[i] {
                diff += 1;
                if diff > 3 {
                    return false;
                }
            }
        }
        true
    }
}