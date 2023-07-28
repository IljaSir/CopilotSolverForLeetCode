impl Solution {
    pub fn detect_capital_use(word: String) -> bool {
        
        let mut all_cap = true;
        let mut all_small = true;
        let mut first_cap = true;
        let mut first_small = true;
        for (i, c) in word.chars().enumerate() {
            if i == 0 {
                if c.is_uppercase() {
                    first_cap = true;
                    first_small = false;
                } else {
                    first_cap = false;
                    first_small = true;
                }
            } else {
                if c.is_uppercase() {
                    all_cap = true;
                    all_small = false;
                } else {
                    all_cap = false;
                    all_small = true;
                }
            }
        }
        all_cap || all_small || (first_cap && first_small)
    }
}