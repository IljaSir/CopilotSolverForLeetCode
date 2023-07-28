impl Solution {
    pub fn camel_match(queries: Vec<String>, pattern: String) -> Vec<bool> {
        
        let mut result = Vec::new();
        for q in queries {
            result.push(Self::is_match(q, pattern.clone()));
        }
        result
    }
    fn is_match(query: String, pattern: String) -> bool {
        let mut q = query.chars();
        let mut p = pattern.chars();
        let mut last = ' ';
        let mut q_char = q.next();
        let mut p_char = p.next();
        while q_char.is_some() {
            if q_char.unwrap() == p_char.unwrap_or(' ') {
                last = q_char.unwrap();
                q_char = q.next();
                p_char = p.next();
            } else if q_char.unwrap().is_uppercase() {
                return false;
            } else if last.is_uppercase() && q_char.unwrap() == last.to_lowercase().next().unwrap() {
                q_char = q.next();
            } else {
                return false;
            }
        }
        p_char.is_none()
    }
}