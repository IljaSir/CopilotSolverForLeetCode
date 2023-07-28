impl Solution {
    pub fn camel_match(queries: Vec<String>, pattern: String) -> Vec<bool> {
        
        let mut res = Vec::new();
        for query in queries {
            let mut flag = true;
            let mut i = 0;
            for c in query.chars() {
                if i < pattern.len() && c == pattern.chars().nth(i).unwrap() {
                    i += 1;
                } else if c.is_uppercase() {
                    flag = false;
                    break;
                }
            }
            if i != pattern.len() {
                flag = false;
            }
            res.push(flag);
        }
        res
    }
}