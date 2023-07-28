impl Solution {
    pub fn count_valid_words(sentence: String) -> i32 {
        
        let mut count = 0;
        let mut hyphen = false;
        let mut punct = false;
        let mut valid = true;
        for c in sentence.chars() {
            if c == ' ' {
                if hyphen || punct {
                    valid = false;
                }
                if valid {
                    count += 1;
                }
                hyphen = false;
                punct = false;
                valid = true;
            } else if c.is_lowercase() {
                continue;
            } else if c == '-' {
                if hyphen || punct {
                    valid = false;
                }
                hyphen = true;
            } else if c == '!' || c == '.' || c == ',' {
                if punct {
                    valid = false;
                }
                punct = true;
            } else {
                valid = false;
            }
        }
        if hyphen || punct {
            valid = false;
        }
        if valid {
            count += 1;
        }
        count
    }
}