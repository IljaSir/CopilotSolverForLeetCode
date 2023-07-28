impl Solution {
    pub fn remove_digit(number: String, digit: char) -> String {
        
        let mut res = String::new();
        let mut cnt = 1;
        for c in number.chars() {
            if c == digit {
                if cnt > 0 {
                    cnt -= 1;
                } else {
                    res.push(c);
                }
            } else {
                res.push(c);
            }
        }
        res
    }
}