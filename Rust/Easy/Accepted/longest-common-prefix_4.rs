impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        
        let mut prefix = String::new();
        if strs.is_empty() {
            return prefix;
        }
        let mut shortest = strs[0].len();
        for s in strs.iter() {
            if s.len() < shortest {
                shortest = s.len();
            }
        }
        for i in 0..shortest {
            let mut c = strs[0].chars().nth(i).unwrap();
            for s in strs.iter() {
                if s.chars().nth(i).unwrap() != c {
                    return prefix;
                }
            }
            prefix.push(c);
        }
        prefix
    }
}