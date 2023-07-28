impl Solution {
    pub fn detect_capital_use(word: String) -> bool {
        
        let mut word = word.chars().collect::<Vec<_>>();
        let mut is_all_upper = true;
        let mut is_all_lower = true;
        let mut is_first_upper = true;
        for (i, c) in word.iter().enumerate() {
            if i == 0 {
                if !c.is_uppercase() {
                    is_first_upper = false;
                }
            } else {
                if c.is_uppercase() {
                    is_all_lower = false;
                } else {
                    is_all_upper = false;
                }
            }
        }
        is_all_lower || is_all_upper || is_first_upper
    }
}