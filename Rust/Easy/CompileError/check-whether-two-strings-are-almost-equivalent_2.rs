impl Solution {
    pub fn check_almost_equivalent(word1: String, word2: String) -> bool {
        
        let mut count1 = [0; 26];
        let mut count2 = [0; 26];
        for c in word1.chars() {
            count1[c as usize - 'a' as usize] += 1;
        }
        for c in word2.chars() {
            count2[c as usize - 'a' as usize] += 1;
        }
        let mut diff = 0;
        for i in 0..26 {
            diff += (count1[i] - count2[i]).abs();
        }
        diff <= 3
    }
}