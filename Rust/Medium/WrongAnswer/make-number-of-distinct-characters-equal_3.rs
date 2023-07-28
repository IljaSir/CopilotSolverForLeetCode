impl Solution {
    pub fn is_it_possible(word1: String, word2: String) -> bool {
        
        if word1.len() != word2.len() {
            return false;
        }
        let mut count1 = [0; 26];
        let mut count2 = [0; 26];
        for (c1, c2) in word1.chars().zip(word2.chars()) {
            let i1 = (c1 as u8 - b'a') as usize;
            let i2 = (c2 as u8 - b'a') as usize;
            count1[i1] += 1;
            count2[i2] += 1;
        }
        let mut diff = 0;
        for i in 0..26 {
            if count1[i] != count2[i] {
                diff += 1;
            }
        }
        diff <= 2
    }
}