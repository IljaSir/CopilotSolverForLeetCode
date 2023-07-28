impl Solution {
    pub fn word_count(start_words: Vec<String>, target_words: Vec<String>) -> i32 {
        
        let mut result = 0;
        for word in target_words {
            let mut flag = true;
            let mut count = 0;
            for start in &start_words {
                if word.len() == start.len() {
                    if word == *start {
                        flag = false;
                        break;
                    }
                } else if word.len() == start.len() + 1 {
                    for i in 0..start.len() {
                        if word[i..] == start[i..] {
                            count += 1;
                            break;
                        }
                    }
                }
            }
            if flag && count == 1 {
                result += 1;
            }
        }
        result
    }
}