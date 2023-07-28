impl Solution {
    pub fn camel_match(queries: Vec<String>, pattern: String) -> Vec<bool> {
        
        let mut res = Vec::new();
        for query in queries {
            let mut i = 0;
            let mut j = 0;
            let mut match_flag = true;
            while i < query.len() {
                let q = query.chars().nth(i).unwrap();
                if j < pattern.len() {
                    let p = pattern.chars().nth(j).unwrap();
                    if q == p {
                        j += 1;
                    } else if q.is_uppercase() {
                        match_flag = false;
                        break;
                    }
                } else if q.is_uppercase() {
                    match_flag = false;
                    break;
                }
                i += 1;
            }
            if j < pattern.len() {
                match_flag = false;
            }
            res.push(match_flag);
        }
        res
    }
}