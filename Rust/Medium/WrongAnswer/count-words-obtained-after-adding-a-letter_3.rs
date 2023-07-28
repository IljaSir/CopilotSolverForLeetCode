impl Solution {
    pub fn word_count(start_words: Vec<String>, target_words: Vec<String>) -> i32 {
        
        let mut count = 0;
        for target in target_words.iter() {
            let mut is_valid = false;
            for start in start_words.iter() {
                if target.len() > start.len() {
                    continue;
                }
                let mut is_match = true;
                let mut chars = target.chars().collect::<Vec<char>>();
                for c in start.chars() {
                    if let Some(idx) = chars.iter().position(|&x| x == c) {
                        chars.remove(idx);
                    }
                }
                if chars.len() > 0 {
                    is_match = false;
                }
                if is_match {
                    is_valid = true;
                    break;
                }
            }
            if is_valid {
                count += 1;
            }
        }
        count
    }
}