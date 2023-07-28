impl Solution {
    pub fn check_almost_equivalent(word1: String, word2: String) -> bool {
        
        let mut word1 = word1.chars().collect::<Vec<char>>();
        let mut word2 = word2.chars().collect::<Vec<char>>();
        word1.sort();
        word2.sort();
        let mut i = 0;
        let mut j = 0;
        let mut diff = 0;
        while i < word1.len() && j < word2.len() {
            if word1[i] == word2[j] {
                i += 1;
                j += 1;
            } else if word1[i] != word2[j] {
                diff += 1;
                if diff > 3 {
                    return false;
                }
                if i + 1 < word1.len() && word1[i] == word1[i + 1] {
                    i += 1;
                } else if j + 1 < word2.len() && word2[j] == word2[j + 1] {
                    j += 1;
                } else {
                    i += 1;
                    j += 1;
                }
            }
        }
        if i < word1.len() || j < word2.len() {
            diff += 1;
        }
        diff <= 3
    }
}