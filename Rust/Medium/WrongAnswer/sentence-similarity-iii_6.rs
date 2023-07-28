impl Solution {
    pub fn are_sentences_similar(sentence1: String, sentence2: String) -> bool {
        
        let s1 = sentence1.split(" ").collect::<Vec<_>>();
        let s2 = sentence2.split(" ").collect::<Vec<_>>();
        let n1 = s1.len();
        let n2 = s2.len();
        if n1 > n2 {
            return Self::are_sentences_similar(sentence2, sentence1);
        }
        let mut i = 0;
        while i < n1 && s1[i] == s2[i] {
            i += 1;
        }
        if i == n1 {
            return true;
        }
        let mut j = 0;
        while j < n1 && s1[n1 - 1 - j] == s2[n2 - 1 - j] {
            j += 1;
        }
        i + j == n1
    }
}