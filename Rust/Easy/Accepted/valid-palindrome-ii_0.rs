impl Solution {
    pub fn valid_palindrome(s: String) -> bool {
        
        let s: Vec<char> = s.chars().collect();
        let mut i = 0;
        let mut j = s.len() - 1;
        while i < j {
            if s[i] != s[j] {
                return Self::is_palindrome(&s, i + 1, j) || Self::is_palindrome(&s, i, j - 1);
            }
            i += 1;
            j -= 1;
        }
        true
    }
    fn is_palindrome(s: &Vec<char>, mut i: usize, mut j: usize) -> bool {
        while i < j {
            if s[i] != s[j] {
                return false;
            }
            i += 1;
            j -= 1;
        }
        true
    }
}