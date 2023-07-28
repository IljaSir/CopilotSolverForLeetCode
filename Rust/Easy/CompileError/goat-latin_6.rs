impl Solution {
    pub fn to_goat_latin(sentence: String) -> String {
        
        let mut result = String::new();
        let mut index = 1;
        for word in sentence.split_whitespace() {
            let mut word = word.to_string();
            if !word.starts_with(|c: char| c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                word.push(word.remove(0));
            }
            word.push_str("ma");
            for _ in 0..index {
                word.push('a');
            }
            index += 1;
            result.push_str(&word);
            result.push(' ');
        }
        result.pop();
        result
    }
}