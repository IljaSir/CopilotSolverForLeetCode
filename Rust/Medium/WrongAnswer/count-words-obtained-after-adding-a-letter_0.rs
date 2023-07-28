impl Solution {
    pub fn word_count(start_words: Vec<String>, target_words: Vec<String>) -> i32 {
        
        let mut count = 0;
        for target_word in target_words {
            for start_word in &start_words {
                if Solution::is_valid(start_word, &target_word) {
                    count += 1;
                    break;
                }
            }
        }
        count
    }
    fn is_valid(start_word: &String, target_word: &String) -> bool {
        if start_word.len() + 1 != target_word.len() {
            return false;
        }
        let mut start_word = start_word.clone();
        for c in target_word.chars() {
            if start_word.contains(c) {
                let index = start_word.find(c).unwrap();
                start_word.remove(index);
            } else {
                start_word.push(c);
            }
        }
        start_word == *target_word
    }
}