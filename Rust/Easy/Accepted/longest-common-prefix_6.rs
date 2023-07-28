impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        
        if strs.len() == 0 {
            return String::from("");
        }
        let mut prefix = String::from("");
        let mut i = 0;
        loop {
            let mut c = ' ';
            for s in &strs {
                if i >= s.len() {
                    return prefix;
                }
                if c == ' ' {
                    c = s.chars().nth(i).unwrap();
                } else if c != s.chars().nth(i).unwrap() {
                    return prefix;
                }
            }
            prefix.push(c);
            i += 1;
        }
    }
}