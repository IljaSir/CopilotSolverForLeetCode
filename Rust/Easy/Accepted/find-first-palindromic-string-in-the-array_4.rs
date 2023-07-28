impl Solution {
    pub fn first_palindrome(words: Vec<String>) -> String {
        
        let mut result = String::new();
        for word in words {
            if word == word.chars().rev().collect::<String>() {
                result = word;
                break;
            }
        }
        result
    }
}