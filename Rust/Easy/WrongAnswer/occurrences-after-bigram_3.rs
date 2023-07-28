impl Solution {
    pub fn find_ocurrences(text: String, first: String, second: String) -> Vec<String> {
        
        let mut result = vec![];
        let mut words = text.split(' ').peekable();
        while let Some(word) = words.next() {
            if word == first && words.peek() == Some(&second.as_str()) {
                if let Some(third) = words.next() {
                    result.push(third.to_string());
                }
            }
        }
        result
    }
}