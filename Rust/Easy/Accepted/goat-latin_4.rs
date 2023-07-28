impl Solution {
    pub fn to_goat_latin(sentence: String) -> String {
        
        let mut result = String::new();
        let mut a = "a".to_string();
        for word in sentence.split_whitespace() {
            if word.starts_with(|c: char| "aeiouAEIOU".contains(c)) {
                result.push_str(&word);
            } else {
                result.push_str(&word[1..]);
                result.push(word.chars().nth(0).unwrap());
            }
            result.push_str("ma");
            result.push_str(&a);
            a.push('a');
            result.push(' ');
        }
        result.pop();
        result
    }
}