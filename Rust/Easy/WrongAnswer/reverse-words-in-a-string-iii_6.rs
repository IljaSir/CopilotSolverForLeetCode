impl Solution {
    pub fn reverse_words(s: String) -> String {
        
        let mut s = s;
        let mut result = String::new();
        while let Some(index) = s.find(' ') {
            let word = s.drain(..index + 1).collect::<String>();
            result.push_str(&word.chars().rev().collect::<String>());
        }
        if !s.is_empty() {
            result.push_str(&s.chars().rev().collect::<String>());
        }
        result
    }
}