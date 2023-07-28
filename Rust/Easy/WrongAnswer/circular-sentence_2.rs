impl Solution {
    pub fn is_circular_sentence(sentence: String) -> bool {
        
        let mut words = sentence.split(" ");
        let mut prev = words.next().unwrap().chars().last().unwrap();
        for word in words {
            if prev != word.chars().next().unwrap() {
                return false;
            }
            prev = word.chars().last().unwrap();
        }
        true
    }
}