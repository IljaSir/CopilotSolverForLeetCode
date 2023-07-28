impl Solution {
    pub fn remove_digit(number: String, digit: char) -> String {
        
        let mut result = "".to_string();
        let mut found = false;
        for c in number.chars() {
            if c == digit && !found {
                found = true;
            } else {
                result.push(c);
            }
        }
        result
    }
}