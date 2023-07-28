impl Solution {
    pub fn is_it_possible(word1: String, word2: String) -> bool {
        
        let mut word1 = word1.into_bytes();
        let mut word2 = word2.into_bytes();
        let mut c1 = vec![0; 26];
        let mut c2 = vec![0; 26];
        for i in 0..word1.len() {
            c1[word1[i] as usize - 'a' as usize] += 1;
            c2[word2[i] as usize - 'a' as usize] += 1;
        }
        let mut diff = 0;
        for i in 0..26 {
            if c1[i] == c2[i] {
                continue;
            }
            if c1[i] > c2[i] {
                diff += c1[i] - c2[i];
            } else {
                diff += (c2[i] - c1[i]) / 2;
            }
        }
        diff <= 1
    }
}