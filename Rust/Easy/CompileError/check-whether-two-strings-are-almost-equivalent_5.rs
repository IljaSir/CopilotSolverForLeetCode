impl Solution {
    pub fn check_almost_equivalent(word1: String, word2: String) -> bool {
        
        let mut v1 = vec![0; 26];
        let mut v2 = vec![0; 26];
        for c in word1.chars() {
            v1[(c as u8 - 'a' as u8) as usize] += 1;
        }
        for c in word2.chars() {
            v2[(c as u8 - 'a' as u8) as usize] += 1;
        }
        let mut diff = 0;
        for i in 0..26 {
            diff += (v1[i] - v2[i]).abs();
            if diff > 6 {
                return false;
            }
        }
        true
    }
}