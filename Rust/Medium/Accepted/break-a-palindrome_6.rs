impl Solution {
    pub fn break_palindrome(palindrome: String) -> String {
        
        let n = palindrome.len();
        let mut res: Vec<char> = palindrome.chars().collect();
        if n == 1 { return "".to_string(); }
        for i in 0..n/2 {
            if res[i] != 'a' {
                res[i] = 'a';
                return res.into_iter().collect();
            }
        }
        res[n-1] = 'b';
        res.into_iter().collect()
    }
}