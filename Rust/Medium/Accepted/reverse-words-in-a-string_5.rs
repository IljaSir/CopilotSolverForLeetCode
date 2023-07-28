impl Solution {
    pub fn reverse_words(s: String) -> String {
        

        let mut words = s.split_whitespace();
        let mut result = String::new();
        while let Some(word) = words.next() {
            result = format!("{} {}", word, result);
        }
        result.trim().to_string()
    }
}