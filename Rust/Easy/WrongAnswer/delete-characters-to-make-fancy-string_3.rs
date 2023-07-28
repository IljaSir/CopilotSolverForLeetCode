impl Solution {
    pub fn make_fancy_string(s: String) -> String {
        
        let mut result = String::new();
        let mut last = ' ';
        let mut count = 0;
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
            result.push(c);
        }
        result
    }
}