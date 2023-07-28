impl Solution {
    pub fn to_goat_latin(sentence: String) -> String {
        
        let mut result = String::new();
        let vowels = vec!['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'];
        let mut words = sentence.split_whitespace();
        let mut index = 1;
        while let Some(word) = words.next() {
            let mut word = word.to_string();
            if !vowels.contains(&word.chars().nth(0).unwrap()) {
                word = word[1..].to_string();
                word.push(word.chars().nth(0).unwrap());
            }
            word.push_str("ma");
            for _ in 0..index {
                word.push('a');
            }
            result.push_str(&word);
            if words.next().is_some() {
                result.push(' ');
            }
            index += 1;
        }
        result
    }
}