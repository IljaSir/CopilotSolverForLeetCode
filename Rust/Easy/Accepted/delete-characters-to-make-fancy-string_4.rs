impl Solution {
    pub fn make_fancy_string(s: String) -> String {
        
        let mut ret = String::new();
        let mut count = 0;
        let mut prev = ' ';
        for c in s.chars() {
            if c == prev {
                count += 1;
                if count < 3 {
                    ret.push(c);
                }
            } else {
                count = 1;
                ret.push(c);
            }
            prev = c;
        }
        ret
    }
}