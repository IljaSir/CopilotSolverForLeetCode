impl Solution {
    pub fn are_sentences_similar(sentence1: String, sentence2: String) -> bool {
        
        if sentence1 == sentence2 {
            return true;
        }
        let words1: Vec<String> = sentence1.split(" ").map(|s| s.to_string()).collect();
        let words2: Vec<String> = sentence2.split(" ").map(|s| s.to_string()).collect();
        if words1.len() == words2.len() {
            return false;
        }
        let (mut shorter, mut longer) = (words1, words2);
        if longer.len() < shorter.len() {
            std::mem::swap(&mut shorter, &mut longer);
        }
        let mut i = 0;
        let mut j = 0;
        while i < shorter.len() && j < longer.len() {
            if shorter[i] == longer[j] {
                i += 1;
                j += 1;
            } else {
                j += 1;
            }
        }
        i == shorter.len()
    }
}