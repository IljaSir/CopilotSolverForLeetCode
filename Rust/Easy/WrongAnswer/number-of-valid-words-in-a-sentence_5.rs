impl Solution {
    pub fn count_valid_words(sentence: String) -> i32 {
        
        let mut count = 0;
        let mut last = ' ';
        let mut hyphen = false;
        let mut punctuation = false;
        for c in sentence.chars() {
            if c == ' ' {
                if last != ' ' && !hyphen && !punctuation {
                    count += 1;
                }
                hyphen = false;
                punctuation = false;
            } else if c == '-' {
                if last == ' ' || hyphen || punctuation || last == '-' {
                    return 0;
                }
                hyphen = true;
            } else if c == '!' || c == '.' || c == ',' {
                if punctuation || last == ' ' {
                    return 0;
                }
                punctuation = true;
            } else {
                if c < 'a' || c > 'z' {
                    return 0;
                }
            }
            last = c;
        }
        if last != ' ' && !hyphen && !punctuation {
            count += 1;
        }
        count
    }
}