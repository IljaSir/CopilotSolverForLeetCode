impl Solution {
    pub fn camel_match(queries: Vec<String>, pattern: String) -> Vec<bool> {
        
        let mut res = Vec::new();
        for query in queries {
            let mut q = query.chars();
            let mut p = pattern.chars();
            let mut q_c = q.next();
            let mut p_c = p.next();
            let mut matched = true;
            while matched {
                match (q_c, p_c) {
                    (Some(q_c), Some(p_c)) => {
                        if q_c == p_c {
                            q_c = q.next();
                            p_c = p.next();
                        } else if q_c.is_uppercase() {
                            matched = false;
                        } else {
                            q_c = q.next();
                        }
                    }
                    (Some(q_c), None) => {
                        if q_c.is_uppercase() {
                            matched = false;
                        } else {
                            q_c = q.next();
                        }
                    }
                    (None, Some(_)) => {
                        matched = false;
                    }
                    (None, None) => {
                        break;
                    }
                }
            }
            res.push(matched);
        }
        res
    }
}