impl Solution {
    pub fn to_goat_latin(sentence: String) -> String {
        
        let mut result = String::new();
        let words: Vec<&str> = sentence.split(" ").collect();
        let vowels = vec!['a', 'e', 'i', 'o', 'u'];
        for (i, word) in words.iter().enumerate() {
            let mut word = word.to_string();
            if vowels.contains(&word.chars().nth(0).unwrap().to_ascii_lowercase()) {
                word.push_str("ma");
            } else {
                word.push(word.chars().nth(0).unwrap());
                word.remove(0);
                word.push_str("ma");
            }
            word.push_str(&"a".repeat(i + 1));
            result.push_str(&word);
            result.push_str(" ");
        }
        result.pop();
        result
    }
}