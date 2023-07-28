impl Solution {
    pub fn longest_prefix(s: String) -> String {
        
        let mut result = String::new();
        let mut left = 0;
        let mut right = s.len() - 1;
        while left < s.len() && right > 0 {
            if s.chars().take(left + 1).collect::<String>() == s.chars().rev().take(right + 1).collect::<String>() {
                result = s.chars().take(left + 1).collect::<String>();
            }
            left += 1;
            right -= 1;
        }
        result
    }
}