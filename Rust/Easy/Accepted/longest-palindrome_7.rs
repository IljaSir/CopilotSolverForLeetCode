impl Solution {
    pub fn longest_palindrome(s: String) -> i32 {
        
        let mut chars = vec![0; 128];
        for c in s.chars() {
            chars[c as usize] += 1;
        }
        let mut result = 0;
        for c in chars {
            if c % 2 == 0 {
                result += c;
            } else {
                result += c - 1;
                if result % 2 == 0 {
                    result += 1;
                }
            }
        }
        result
    }
}