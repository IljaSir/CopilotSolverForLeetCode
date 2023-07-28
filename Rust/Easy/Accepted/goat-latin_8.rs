impl Solution {
    pub fn to_goat_latin(sentence: String) -> String {
        
        let mut result = String::new();
        let mut count = 1;
        for word in sentence.split_whitespace() {
            let mut word = word.to_string();
            if !word.starts_with(|c: char| c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                let c = word.remove(0);
                word.push(c);
            }
            word.push_str("ma");
            word.push_str(&"a".repeat(count));
            result.push_str(&word);
            result.push(' ');
            count += 1;
        }
        result.pop();
        result
    }
}