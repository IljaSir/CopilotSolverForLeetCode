impl Solution {
    pub fn camel_match(queries: Vec<String>, pattern: String) -> Vec<bool> {
        
        let mut ans = Vec::new();
        for q in queries {
            let mut p = pattern.clone();
            let mut matched = true;
            for c in q.chars() {
                if let Some(f) = p.chars().next() {
                    if c == f {
                        p.remove(0);
                        continue;
                    }
                }
                if c.is_uppercase() {
                    matched = false;
                    break;
                }
            }
            if !p.is_empty() {
                matched = false;
            }
            ans.push(matched);
        }
        ans
    }
}