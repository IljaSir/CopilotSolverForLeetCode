impl Solution {
    pub fn largest_odd_number(num: String) -> String {
        
        for (i, c) in num.chars().rev().enumerate() {
            if c.to_digit(10).unwrap() % 2 != 0 {
                return num[..num.len() - i].to_string();
            }
        }
        "".to_string()
    }
}