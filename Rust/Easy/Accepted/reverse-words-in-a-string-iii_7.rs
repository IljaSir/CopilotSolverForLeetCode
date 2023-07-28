impl Solution {
    pub fn reverse_words(s: String) -> String {
        
        let mut result = "".to_string();
        let mut words = s.split(" ");
        for word in words {
            let mut chars = word.chars();
            let mut chars_vec: Vec<char> = Vec::new();
            for char in chars {
                chars_vec.push(char);
            }
            chars_vec.reverse();
            let mut chars_str = "".to_string();
            for char in chars_vec {
                chars_str.push(char);
            }
            result.push_str(&chars_str);
            result.push_str(" ");
        }
        result.pop();
        result
    }
}