impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        
        let mut prefix = String::new();
        let mut i = 0;
        'outer: loop {
            let mut c = None;
            for s in &strs {
                if i >= s.len() {
                    break 'outer;
                }
                if let Some(ch) = c {
                    if ch != s.as_bytes()[i] {
                        break 'outer;
                    }
                } else {
                    c = Some(s.as_bytes()[i]);
                }
            }
            prefix.push(c.unwrap() as char);
            i += 1;
        }
        return prefix;
    }
}