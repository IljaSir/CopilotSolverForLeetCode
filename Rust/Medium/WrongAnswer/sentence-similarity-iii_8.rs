impl Solution {
    pub fn are_sentences_similar(sentence1: String, sentence2: String) -> bool {
        
        let s1 = sentence1.split(' ').collect::<Vec<&str>>();
        let s2 = sentence2.split(' ').collect::<Vec<&str>>();
        if s1.len() < s2.len() {
            Self::are_sentences_similar(sentence2, sentence1)
        } else {
            let mut i = 0;
            let mut j = 0;
            while i < s1.len() && j < s2.len() {
                if s1[i] == s2[j] {
                    i += 1;
                    j += 1;
                } else {
                    break;
                }
            }
            if j == s2.len() {
                true
            } else {
                i = s1.len() - 1;
                j = s2.len() - 1;
                while i >= 0 && j >= 0 {
                    if s1[i] == s2[j] {
                        i -= 1;
                        j -= 1;
                    } else {
                        break;
                    }
                }
                j < 0
            }
        }
    }
}