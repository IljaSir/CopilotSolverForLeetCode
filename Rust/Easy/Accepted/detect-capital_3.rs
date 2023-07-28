impl Solution {
    pub fn detect_capital_use(word: String) -> bool {
        
        let mut c = 0;
        for i in word.chars() {
            if i.is_uppercase() {
                c += 1;
            }
        }
        c == 0 || c == word.len() || (c == 1 && word.chars().next().unwrap().is_uppercase())
    }
}