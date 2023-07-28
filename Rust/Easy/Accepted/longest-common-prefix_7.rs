impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        
        if strs.len() == 0 {
            return String::from("");
        }
        let mut prefix = String::from("");
        let mut i = 0;
        loop {
            let mut ch = '\0';
            for s in strs.iter() {
                if i >= s.len() {
                    return prefix;
                }
                if ch == '\0' {
                    ch = s.chars().nth(i).unwrap();
                } else if ch != s.chars().nth(i).unwrap() {
                    return prefix;
                }
            }
            prefix.push(ch);
            i += 1;
        }
    }
}