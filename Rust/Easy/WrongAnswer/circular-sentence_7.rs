impl Solution {
    pub fn is_circular_sentence(sentence: String) -> bool {
        
        let mut words = sentence.split_whitespace();
        let first = words.next().unwrap();
        let last = words.fold(first, |_, x| x);
        last.chars().last().unwrap() == first.chars().next().unwrap()
    }
}