impl Solution {
    pub fn to_goat_latin(sentence: String) -> String {
        
        let mut res = String::new();
        let mut index = 1;
        for word in sentence.split_whitespace() {
            let mut word = word.to_string();
            let first_char = word.chars().next().unwrap();
            if !("aeiouAEIOU".contains(first_char)) {
                let c = word.remove(0);
                word.push(c);
            }
            word.push_str("ma");
            word.push_str(&"a".repeat(index));
            res.push_str(&word);
            res.push(' ');
            index += 1;
        }
        res.pop();
        res
    }
}