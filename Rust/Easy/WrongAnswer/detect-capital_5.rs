impl Solution {
    pub fn detect_capital_use(word: String) -> bool {
        
        let mut is_capital = false;
        let mut is_lower = false;
        let mut is_upper = false;
        for c in word.chars() {
            if c.is_uppercase() {
                if is_lower {
                    return false;
                }
                is_upper = true;
            } else {
                if is_upper {
                    return false;
                }
                is_lower = true;
            }
        }
        true
    }
}