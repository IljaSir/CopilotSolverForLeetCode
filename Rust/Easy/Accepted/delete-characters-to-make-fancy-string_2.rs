impl Solution {
    pub fn make_fancy_string(s: String) -> String {
        
        let mut res = String::new();
        let mut count = 0;
        let mut last_char = ' ';
        for c in s.chars() {
            if c == last_char {
                count += 1;
            } else {
                last_char = c;
                count = 1;
            }
            if count < 3 {
                res.push(c);
            }
        }
        res
    }
}