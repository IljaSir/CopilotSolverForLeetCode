impl Solution {
    pub fn remove_digit(number: String, digit: char) -> String {
        
        let mut result = String::new();
        let mut remove = false;
        for c in number.chars() {
            if c == digit && !remove {
                remove = true;
            } else {
                result.push(c);
            }
        }
        result
    }
}