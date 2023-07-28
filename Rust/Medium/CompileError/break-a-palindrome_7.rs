impl Solution {
    pub fn break_palindrome(palindrome: String) -> String {
        
        let mut chars = palindrome.chars().collect::<Vec<char>>();
        let mut changed = false;
        let mut i = 0;
        while i < chars.len() / 2 {
            if chars[i] != 'a' {
                chars[i] = 'a';
                changed = true;
                break;
            }
            i += 1;
        }
        if !changed {
            if chars.len() > 1 {
                chars[chars.len() - 1] = 'b';
            } else {
                return String::from("");
            }
        }
        chars.iter().collect::<String>()
    }
}