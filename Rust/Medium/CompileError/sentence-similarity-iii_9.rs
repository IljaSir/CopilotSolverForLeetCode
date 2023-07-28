impl Solution {
    pub fn are_sentences_similar(sentence1: String, sentence2: String) -> bool {
        
        let mut s1 = sentence1.split(" ");
        let mut s2 = sentence2.split(" ");
        let mut s1_last = s1.next_back();
        let mut s2_last = s2.next_back();
        while s1_last.is_some() && s2_last.is_some() && s1_last == s2_last {
            s1_last = s1.next_back();
            s2_last = s2.next_back();
        }
        if s1_last.is_none() && s2_last.is_none() {
            return true;
        }
        let mut s1_first = s1.next();
        let mut s2_first = s2.next();
        while s1_first.is_some() && s2_first.is_some() && s1_first == s2_first {
            s1_first = s1.next();
            s2_first = s2.next();
        }
        s1_first.is_none() && s2_first.is_none()
    }
}