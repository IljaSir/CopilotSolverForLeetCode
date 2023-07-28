impl Solution {
    pub fn reverse_prefix(word: String, ch: char) -> String {
        
        let mut index = 0;
        let mut result = String::new();
        for c in word.chars() {
            if c == ch {
                break;
            }
            index += 1;
        }
        for i in (0..=index).rev() {
            result.push(word.chars().nth(i).unwrap());
        }
        result.push_str(&word[index + 1..]);
        result
    }
}