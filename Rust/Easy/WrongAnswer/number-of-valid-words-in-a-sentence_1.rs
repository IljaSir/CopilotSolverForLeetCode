impl Solution {
    pub fn count_valid_words(sentence: String) -> i32 {
        
        let mut count = 0;
        for word in sentence.split_whitespace() {
            let mut hyphen = false;
            let mut punc = false;
            let mut valid = true;
            for c in word.chars() {
                if c.is_lowercase() {
                    continue;
                } else if c == '-' {
                    if hyphen || punc {
                        valid = false;
                        break;
                    }
                    hyphen = true;
                } else if c == '!' || c == '.' || c == ',' {
                    if punc {
                        valid = false;
                        break;
                    }
                    punc = true;
                } else {
                    valid = false;
                    break;
                }
            }
            if valid {
                count += 1;
            }
        }
        count
    }
}