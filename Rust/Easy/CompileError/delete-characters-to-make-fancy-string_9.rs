impl Solution {
    pub fn make_fancy_string(s: String) -> String {
        
        let mut ret = String::new();
        let mut count = 0;
        let mut prev = 0;
        for c in s.chars() {
            let c = c as u8 - 'a' as u8;
            if prev == c {
                count += 1;
                if count < 3 {
                    ret.push(c as char + 'a' as char);
                }
            } else {
                count = 1;
                ret.push(c as char + 'a' as char);
            }
            prev = c;
        }
        ret
    }
}