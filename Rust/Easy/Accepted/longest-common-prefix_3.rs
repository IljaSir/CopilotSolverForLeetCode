impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        
        let mut prefix = String::new();
        let mut i = 0;
        loop {
            let mut c = None;
            for s in strs.iter() {
                if i >= s.len() {
                    return prefix;
                }
                if let Some(cc) = c {
                    if cc != s.as_bytes()[i] {
                        return prefix;
                    }
                } else {
                    c = Some(s.as_bytes()[i]);
                }
            }
            prefix.push(c.unwrap() as char);
            i += 1;
        }
    }
}