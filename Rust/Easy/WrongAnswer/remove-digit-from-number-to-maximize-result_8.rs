impl Solution {
    pub fn remove_digit(number: String, digit: char) -> String {
        
        let mut i = 0;
        let mut j = 0;
        let mut res = String::new();
        while j < number.len() {
            if number.as_bytes()[j] == digit as u8 {
                j += 1;
            } else if i != j {
                res.push(number.as_bytes()[j] as char);
                j += 1;
            } else {
                res.push(number.as_bytes()[j] as char);
                i += 1;
                j += 1;
            }
        }
        res
    }
}