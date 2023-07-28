impl Solution {
    pub fn reverse_words(s: String) -> String {
        
        let mut res = String::new();
        for word in s.split_whitespace() {
            let mut chars: Vec<char> = word.chars().collect();
            chars.reverse();
            res.push_str(&chars.iter().collect::<String>());
            res.push(' ');
        }
        res.pop();
        res
    }
}