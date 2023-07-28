impl Solution {
    pub fn remove_digit(number: String, digit: char) -> String {
        
        let mut res = String::new();
        let mut skip = false;
        for c in number.chars() {
            if c == digit && !skip {
                skip = true;
                continue;
            }
            res.push(c);
        }
        res
    }
}