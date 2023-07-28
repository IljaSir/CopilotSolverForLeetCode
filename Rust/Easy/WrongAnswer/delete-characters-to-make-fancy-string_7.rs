impl Solution {
    pub fn make_fancy_string(s: String) -> String {
        
        let mut res = Vec::new();
        let mut count = 0;
        let mut last = '\0';
        for c in s.chars() {
            if c == last {
                count += 1;
                if count == 3 {
                    continue;
                }
            } else {
                last = c;
                count = 1;
            }
            res.push(c);
        }
        res.into_iter().collect()
    }
}