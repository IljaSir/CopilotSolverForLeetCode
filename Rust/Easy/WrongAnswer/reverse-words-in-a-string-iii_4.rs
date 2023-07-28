impl Solution {
    pub fn reverse_words(s: String) -> String {
        
        let mut result = String::new();
        let mut words = s.split_whitespace();
        while let Some(word) = words.next() {
            result.push_str(&word.chars().rev().collect::<String>());
            if let Some(_) = words.next() {
                result.push(' ');
            }
        }
        result
    }
}