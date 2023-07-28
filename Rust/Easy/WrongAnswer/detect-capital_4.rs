impl Solution {
    pub fn detect_capital_use(word: String) -> bool {
        
        let mut first = true;
        let mut all = true;
        let mut none = true;
        for c in word.chars() {
            if c.is_lowercase() {
                first = false;
                all = false;
            } else {
                none = false;
            }
        }
        first || all || none
    }
}