impl Solution {
    pub fn break_palindrome(palindrome: String) -> String {
        
        let mut chars = palindrome.chars().collect::<Vec<char>>();
        if chars.len() == 1 {
            return "".to_string();
        }
        let mut i = 0;
        while i < chars.len() {
            if chars[i] != 'a' {
                if i == chars.len() - 1 {
                    chars[i] = 'a';
                } else {
                    chars[i] = 'b';
                }
                break;
            }
            i += 1;
        }
        chars.into_iter().collect()
    }
}