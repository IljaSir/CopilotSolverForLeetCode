impl Solution {
    pub fn is_palindrome(s: String) -> bool {
        
        let mut s = s.chars().collect::<Vec<char>>();
        s.retain(|&x| x.is_alphanumeric());
        s = s.into_iter().map(|x| x.to_ascii_lowercase()).collect();
        s == s.into_iter().rev().collect()
    }
}