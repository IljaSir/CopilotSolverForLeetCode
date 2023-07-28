impl Solution {
    pub fn make_fancy_string(s: String) -> String {
        
        let mut res = String::new();
        let mut c = 0;
        let mut last = '\0';
        for ch in s.chars() {
            if ch == last {
                c += 1;
                if c < 3 {
                    res.push(ch);
                }
            } else {
                c = 1;
                res.push(ch);
            }
            last = ch;
        }
        res
    }
}