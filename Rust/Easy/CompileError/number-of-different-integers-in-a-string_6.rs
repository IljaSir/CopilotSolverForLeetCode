impl Solution {
    pub fn num_different_integers(word: String) -> i32 {
        
        let mut num = String::new();
        let mut res = HashSet::new();
        for c in word.chars() {
            if c.is_digit(10) {
                num.push(c);
            } else {
                if !num.is_empty() {
                    res.insert(num.trim_start_matches('0').to_string());
                    num.clear();
                }
            }
        }
        if !num.is_empty() {
            res.insert(num.trim_start_matches('0').to_string());
        }
        res.len() as i32
    }
}