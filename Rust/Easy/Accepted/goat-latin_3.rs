impl Solution {
    pub fn to_goat_latin(sentence: String) -> String {
        
        let mut result = String::new();
        let mut index = 1;
        let vowels = vec!['a', 'e', 'i', 'o', 'u'];
        for word in sentence.split_whitespace() {
            let mut new_word = word.to_string();
            if vowels.contains(&word.chars().nth(0).unwrap().to_ascii_lowercase()) {
                new_word.push_str("ma");
            } else {
                new_word.push(word.chars().nth(0).unwrap());
                new_word.remove(0);
                new_word.push_str("ma");
            }
            new_word.push_str(&"a".repeat(index));
            result.push_str(&new_word);
            result.push(' ');
            index += 1;
        }
        result.pop();
        result
    }
}