impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        
        let mut prefix = String::new();
        let mut i = 0;
        loop {
            let mut c = None;
            for s in &strs {
                if i >= s.len() {
                    return prefix;
                }
                let cc = s.chars().nth(i).unwrap();
                if c.is_none() {
                    c = Some(cc);
                } else if c.unwrap() != cc {
                    return prefix;
                }
            }
            prefix.push(c.unwrap());
            i += 1;
        }
    }
}