impl Solution {
    pub fn is_circular_sentence(sentence: String) -> bool {
        
        let mut words = sentence.split(" ");
        let first = words.next().unwrap();
        let mut last = first;
        for word in words {
            if word.chars().next().unwrap() != last.chars().last().unwrap() {
                return false;
            }
            last = word;
        }
        first.chars().next().unwrap() == last.chars().last().unwrap()
    }
}