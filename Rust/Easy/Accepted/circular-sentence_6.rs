impl Solution {
    pub fn is_circular_sentence(sentence: String) -> bool {
        
        let words: Vec<&str> = sentence.split(' ').collect();
        let mut last = words[words.len() - 1].chars().last().unwrap();
        for word in words {
            if word.chars().next().unwrap() != last {
                return false;
            }
            last = word.chars().last().unwrap();
        }
        true
    }
}