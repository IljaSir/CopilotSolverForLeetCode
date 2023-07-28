impl Solution {
    pub fn make_fancy_string(s: String) -> String {
        
        let mut res = String::new();
        let mut count = 1;
        let mut prev = ' ';
        for c in s.chars() {
            if c == prev {
                count += 1;
                if count < 3 {
                    res.push(c);
                }
            } else {
                count = 1;
                res.push(c);
            }
            prev = c;
        }
        res
    }
}