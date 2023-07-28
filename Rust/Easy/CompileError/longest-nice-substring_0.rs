impl Solution {
    pub fn longest_nice_substring(s: String) -> String {
        
        let mut res = String::new();
        for i in 0..s.len() {
            let mut set = HashSet::new();
            for j in i..s.len() {
                let c = s.chars().nth(j).unwrap();
                if c.is_ascii_uppercase() {
                    set.insert(c.to_ascii_lowercase());
                } else {
                    set.insert(c.to_ascii_uppercase());
                }
                if set.is_empty() {
                    if j - i + 1 > res.len() {
                        res = s[i..j + 1].to_string();
                    }
                }
            }
        }
        res
    }
}