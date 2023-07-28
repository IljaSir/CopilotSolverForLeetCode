impl Solution {
    pub fn replace_digits(s: String) -> String {
        
        let mut res = String::from("");
        let mut chars = s.chars();
        loop {
            match chars.next() {
                None => break,
                Some(c) => {
                    res.push(c);
                    match chars.next() {
                        None => break,
                        Some(d) => {
                            let c = res.pop().unwrap();
                            res.push((c as u8 + d as u8 - '0' as u8) as char);
                        }
                    }
                }
            }
        }
        res
    }
}