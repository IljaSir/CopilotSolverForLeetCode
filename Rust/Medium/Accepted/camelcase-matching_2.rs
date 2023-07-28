impl Solution {
    pub fn camel_match(queries: Vec<String>, pattern: String) -> Vec<bool> {
        
        let mut res = Vec::new();
        for query in queries {
            let mut i = 0;
            let mut j = 0;
            let mut flag = true;
            while i < query.len() {
                if j < pattern.len() && query.chars().nth(i).unwrap() == pattern.chars().nth(j).unwrap() {
                    i += 1;
                    j += 1;
                } else if query.chars().nth(i).unwrap().is_uppercase() {
                    flag = false;
                    break;
                } else {
                    i += 1;
                }
            }
            if flag && j == pattern.len() {
                res.push(true);
            } else {
                res.push(false);
            }
        }
        res
    }
}