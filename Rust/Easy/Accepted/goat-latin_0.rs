impl Solution {
    pub fn to_goat_latin(sentence: String) -> String {
        
        let vowels = vec!['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'];
        let mut words = sentence.split_whitespace();
        let mut res = String::new();
        let mut a = String::from("a");
        while let Some(word) = words.next() {
            if vowels.contains(&word.chars().next().unwrap()) {
                res.push_str(word);
                res.push_str("ma");
                res.push_str(&a);
            } else {
                res.push_str(&word[1..]);
                res.push_str(&word[..1]);
                res.push_str("ma");
                res.push_str(&a);
            }
            if words.clone().next().is_some() {
                res.push(' ');
            }
            a.push('a');
        }
        res
    }
}