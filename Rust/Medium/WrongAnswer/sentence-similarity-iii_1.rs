impl Solution {
    pub fn are_sentences_similar(sentence1: String, sentence2: String) -> bool {
        
        let words1: Vec<&str> = sentence1.split(' ').collect();
        let words2: Vec<&str> = sentence2.split(' ').collect();
        if words1.len() < words2.len() {
            return Self::are_sentences_similar(sentence2, sentence1);
        }
        if words1.len() - words2.len() > 1 {
            return false;
        }
        let mut i = 0;
        while i < words2.len() && words1[i] == words2[i] {
            i += 1;
        }
        let mut j = 0;
        while j < words2.len() && words1[words1.len() - 1 - j] == words2[words2.len() - 1 - j] {
            j += 1;
        }
        i + j == words2.len()
    }
}