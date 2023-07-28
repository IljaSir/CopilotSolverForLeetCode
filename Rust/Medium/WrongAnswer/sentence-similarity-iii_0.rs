impl Solution {
    pub fn are_sentences_similar(sentence1: String, sentence2: String) -> bool {
        
        if sentence1 == sentence2 {
            return true;
        }
        let words1: Vec<&str> = sentence1.split(' ').collect();
        let words2: Vec<&str> = sentence2.split(' ').collect();
        let (mut i, mut j) = (0, 0);
        while i < words1.len() && j < words2.len() {
            if words1[i] == words2[j] {
                i += 1;
                j += 1;
            } else {
                break;
            }
        }
        while i < words1.len() && j < words2.len() {
            if words1[words1.len() - 1 - i] == words2[words2.len() - 1 - j] {
                i += 1;
                j += 1;
            } else {
                break;
            }
        }
        i == words1.len() && j == words2.len()
    }
}