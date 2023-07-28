impl Solution {
    pub fn remove_palindrome_sub(s: String) -> i32 {
        
        if s.is_empty() {
            return 0;
        }
        let chars: Vec<char> = s.chars().collect();
        let mut i = 0;
        let mut j = chars.len() - 1;
        while i < j {
            if chars[i] != chars[j] {
                return 2;
            }
            i += 1;
            j -= 1;
        }
        1
    }
}