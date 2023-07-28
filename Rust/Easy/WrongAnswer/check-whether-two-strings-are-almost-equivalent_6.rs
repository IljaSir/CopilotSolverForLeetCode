impl Solution {
    pub fn check_almost_equivalent(word1: String, word2: String) -> bool {
        
        let mut count1 = [0; 26];
        let mut count2 = [0; 26];
        for (c1, c2) in word1.chars().zip(word2.chars()) {
            count1[c1 as usize - 'a' as usize] += 1;
            count2[c2 as usize - 'a' as usize] += 1;
        }
        count1.iter().zip(count2.iter()).filter(|(c1, c2)| c1 != c2).count() <= 3
    }
}