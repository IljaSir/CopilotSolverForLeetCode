impl Solution {
    pub fn is_palindrome(s: String) -> bool {
        
        let mut v = s
            .chars()
            .filter(|c| c.is_alphanumeric())
            .map(|c| c.to_ascii_lowercase())
            .collect::<Vec<char>>();
        let l = v.len();
        for i in 0..l / 2 {
            if v[i] != v[l - i - 1] {
                return false;
            }
        }
        true
    }
}