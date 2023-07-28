impl Solution {
    pub fn count_valid_words(sentence: String) -> i32 {
        
        let mut count = 0;
        for word in sentence.split(' ') {
            let mut hyphen = false;
            let mut punc = false;
            for c in word.chars() {
                if c == '-' {
                    if hyphen || punc {
                        break;
                    }
                    hyphen = true;
                } else if c == '.' || c == '!' || c == ',' {
                    if punc {
                        break;
                    }
                    punc = true;
                } else if c < 'a' || c > 'z' {
                    break;
                }
            }
            if !hyphen && !punc {
                count += 1;
            }
        }
        count
    }
}