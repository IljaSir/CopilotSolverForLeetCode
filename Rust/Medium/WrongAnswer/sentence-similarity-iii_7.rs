impl Solution {
    pub fn are_sentences_similar(sentence1: String, sentence2: String) -> bool {
        
        let s1 = sentence1.split(" ").collect::<Vec<&str>>();
        let s2 = sentence2.split(" ").collect::<Vec<&str>>();
        if s1.len() != s2.len() {
            if s1.len() < s2.len() {
                return Self::are_sentences_similar(sentence2, sentence1);
            }
            let mut i = 0;
            while i < s2.len() {
                if s1[i] != s2[i] {
                    break;
                }
                i += 1;
            }
            let mut j = 1;
            while j <= s2.len() {
                if s1[s1.len()-j] != s2[s2.len()-j] {
                    break;
                }
                j += 1;
            }
            return i + j - 1 == s1.len();
        }
        for i in 0..s1.len() {
            if s1[i] != s2[i] {
                return false;
            }
        }
        true
    }
}