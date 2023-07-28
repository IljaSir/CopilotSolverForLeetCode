impl Solution {
    pub fn check_almost_equivalent(word1: String, word2: String) -> bool {
        
        let mut freq1 = vec![0; 26];
        let mut freq2 = vec![0; 26];
        for (c1, c2) in word1.chars().zip(word2.chars()) {
            freq1[c1 as usize - 'a' as usize] += 1;
            freq2[c2 as usize - 'a' as usize] += 1;
        }
        let mut diff = 0;
        for i in 0..26 {
            diff += (freq1[i] - freq2[i]).abs();
            if diff > 3 {
                return false;
            }
        }
        true
    }
}