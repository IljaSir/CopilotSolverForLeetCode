impl Solution {
    pub fn are_sentences_similar(sentence1: String, sentence2: String) -> bool {
        
        let s1: Vec<&str> = sentence1.split(" ").collect();
        let s2: Vec<&str> = sentence2.split(" ").collect();
        if s1.len() > s2.len() {
            return Self::are_sentences_similar(sentence2, sentence1);
        }
        let mut i = 0;
        let mut j = s2.len() - 1;
        while i < s1.len() && s1[i] == s2[i] {
            i += 1;
        }
        while j >= i && s1[j - i] == s2[j] {
            j -= 1;
        }
        i >= s1.len() || j < i
    }
}