impl Solution {
    pub fn count_valid_words(sentence: String) -> i32 {
        
        let mut words = sentence.split(' ');
        let mut count = 0;
        for word in words {
            let mut hyphen = false;
            let mut punc = false;
            for c in word.chars() {
                if !c.is_ascii_lowercase() && !c.is_ascii_digit() {
                    if c == '-' {
                        if hyphen {
                            break;
                        } else {
                            hyphen = true;
                        }
                    } else if c == '!' || c == '.' || c == ',' {
                        if punc {
                            break;
                        } else {
                            punc = true;
                        }
                    } else {
                        break;
                    }
                }
            }
            if !hyphen && !punc {
                count += 1;
            }
        }
        count
    }
}