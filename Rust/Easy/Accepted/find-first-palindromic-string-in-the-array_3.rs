impl Solution {
    pub fn first_palindrome(words: Vec<String>) -> String {
        
        for word in words {
            if word.chars().rev().collect::<String>() == word {
                return word;
            }
        }
        "".to_string()
    }
}