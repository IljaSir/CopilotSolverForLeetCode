impl Solution {
    pub fn remove_digit(number: String, digit: char) -> String {
        
        let mut res = String::new();
        let mut found = false;
        for c in number.chars() {
            if c == digit && !found {
                found = true;
            } else {
                res.push(c);
            }
        }
        res
    }
}