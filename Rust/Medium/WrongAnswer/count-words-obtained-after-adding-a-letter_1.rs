impl Solution {
    pub fn word_count(start_words: Vec<String>, target_words: Vec<String>) -> i32 {
        
        let mut count = 0;
        for target_word in target_words {
            let mut found = false;
            for start_word in &start_words {
                if Solution::is_convertable(start_word, &target_word) {
                    found = true;
                    break;
                }
            }
            if found {
                count += 1;
            }
        }
        count
    }
    fn is_convertable(start_word: &String, target_word: &String) -> bool {
        if start_word.len() > target_word.len() {
            return false;
        }
        let mut start_word = start_word.clone();
        for c in target_word.chars() {
            if let Some(index) = start_word.find(c) {
                start_word.remove(index);
            } else {
                start_word.push(c);
            }
        }
        start_word == *target_word
    }
}