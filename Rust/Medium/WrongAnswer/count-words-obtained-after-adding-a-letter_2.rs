impl Solution {
    pub fn word_count(start_words: Vec<String>, target_words: Vec<String>) -> i32 {
        
        let mut count = 0;
        for target_word in &target_words {
            let mut letters = vec![0; 26];
            for c in target_word.chars() {
                letters[c as usize - 97] += 1;
            }
            for start_word in &start_words {
                let mut tmp = letters.clone();
                for c in start_word.chars() {
                    tmp[c as usize - 97] -= 1;
                }
                if tmp.iter().all(|&x| x <= 0) {
                    count += 1;
                    break;
                }
            }
        }
        count
    }
}