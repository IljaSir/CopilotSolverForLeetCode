impl Solution {
    pub fn make_fancy_string(s: String) -> String {
        
        let mut res = String::new();
        let mut count = 1;
        let mut last = None;
        for c in s.chars() {
            if last == Some(c) {
                count += 1;
                if count <= 2 {
                    res.push(c);
                }
            } else {
                last = Some(c);
                count = 1;
                res.push(c);
            }
        }
        res
    }
}