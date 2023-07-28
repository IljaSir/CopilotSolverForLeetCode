impl Solution {
    pub fn detect_capital_use(word: String) -> bool {
        
        if word.len() == 1 {
            return true;
        }
        let mut is_first_capital = false;
        let mut is_all_capital = false;
        let mut is_all_not_capital = false;
        for (i, c) in word.chars().enumerate() {
            if i == 0 {
                if c.is_uppercase() {
                    is_first_capital = true;
                    is_all_capital = true;
                } else {
                    is_all_not_capital = true;
                }
                continue;
            }
            if c.is_uppercase() {
                is_all_not_capital = false;
                if is_first_capital {
                    is_all_capital = true;
                }
            } else {
                is_all_capital = false;
            }
        }
        return is_all_capital || is_all_not_capital;
    }
}