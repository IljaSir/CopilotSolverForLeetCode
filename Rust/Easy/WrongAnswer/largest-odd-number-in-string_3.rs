impl Solution {
    pub fn largest_odd_number(num: String) -> String {
        
        let mut result = String::new();
        for c in num.chars() {
            if c.to_digit(10).unwrap() % 2 == 1 {
                result.push(c);
            }
        }
        result
    }
}