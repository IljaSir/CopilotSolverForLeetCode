impl Solution {
    pub fn detect_capital_use(word: String) -> bool {
        
        let mut count = 0;
        for c in word.chars() {
            if c.is_ascii_uppercase() {
                count += 1;
            }
        }
        if count == word.len() {
            return true;
        }
        if count == 0 {
            return true;
        }
        if count == 1 && word.chars().nth(0).unwrap().is_ascii_uppercase() {
            return true;
        }
        false
    }
}