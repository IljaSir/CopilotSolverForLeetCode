impl Solution {
    pub fn make_fancy_string(s: String) -> String {
        
        let mut res = String::new();
        let mut count = 0;
        let mut last = ' ';
        for c in s.chars() {
            if c != last {
                last = c;
                count = 1;
                res.push(c);
            } else if count < 2 {
                count += 1;
                res.push(c);
            }
        }
        res
    }
}