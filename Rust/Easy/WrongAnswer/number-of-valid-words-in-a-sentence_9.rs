impl Solution {
    pub fn count_valid_words(sentence: String) -> i32 {
        
        let mut count = 0;
        let mut is_valid = true;
        for word in sentence.split_whitespace() {
            is_valid = true;
            if word.len() == 1 {
                if !word.chars().nth(0).unwrap().is_ascii_lowercase() {
                    is_valid = false;
                }
            } else {
                for (i, c) in word.chars().enumerate() {
                    if i == 0 || i == word.len() - 1 {
                        if !c.is_ascii_lowercase() {
                            is_valid = false;
                            break;
                        }
                    } else {
                        if c.is_ascii_digit() {
                            is_valid = false;
                            break;
                        }
                        if c == '-' {
                            if !word.chars().nth(i - 1).unwrap().is_ascii_lowercase()
                                || !word.chars().nth(i + 1).unwrap().is_ascii_lowercase() {
                                is_valid = false;
                                break;
                            }
                        }
                        if c == '!' || c == '.' || c == ',' {
                            if i != word.len() - 1 {
                                is_valid = false;
                                break;
                            }
                        }
                    }
                }
            }
            if is_valid {
                count += 1;
            }
        }
        count
    }
}