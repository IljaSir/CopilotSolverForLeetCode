impl Solution {
    pub fn are_sentences_similar(sentence1: String, sentence2: String) -> bool {
        
        let s1: Vec<&str> = sentence1.split(' ').collect();
        let s2: Vec<&str> = sentence2.split(' ').collect();
        let (s1, s2) = if s1.len() > s2.len() { (s1, s2) } else { (s2, s1) };
        let mut i = 0;
        while i < s2.len() && s1[i] == s2[i] {
            i += 1;
        }
        let mut j = 0;
        while j < s2.len() && s1[s1.len() - j - 1] == s2[s2.len() - j - 1] {
            j += 1;
        }
        i + j >= s2.len()
    }
}