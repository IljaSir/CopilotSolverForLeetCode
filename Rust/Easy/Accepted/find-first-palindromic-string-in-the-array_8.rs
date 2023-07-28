impl Solution {
    pub fn first_palindrome(words: Vec<String>) -> String {
        
        for word in words {
            let word = word.as_bytes();
            if word.iter().zip(word.iter().rev()).all(|(x, y)| x == y) {
                return String::from_utf8(word.to_vec()).unwrap();
            }
        }
        String::new()
    }
}