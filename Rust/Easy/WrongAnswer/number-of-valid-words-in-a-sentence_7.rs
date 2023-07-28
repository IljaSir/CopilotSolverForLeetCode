impl Solution {
    pub fn count_valid_words(sentence: String) -> i32 {
        
        sentence.split_whitespace().filter(|w| {
            let mut hyphen = false;
            let mut punct = false;
            for c in w.chars() {
                if c.is_digit(10) { return false; }
                if c == '-' {
                    if hyphen { return false; }
                    if punct { return false; }
                    hyphen = true;
                }
                if c == '!' || c == '.' || c == ',' {
                    if punct { return false; }
                    punct = true;
                }
            }
            true
        }).count() as i32
    }
}