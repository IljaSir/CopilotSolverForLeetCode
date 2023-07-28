impl Solution {
    pub fn camel_match(queries: Vec<String>, pattern: String) -> Vec<bool> {
        
        let mut result = Vec::new();
        for query in &queries {
            result.push(Self::match_pattern(query, &pattern));
        }
        result
    }

    fn match_pattern(query: &str, pattern: &str) -> bool {
        let mut i = 0;
        let mut j = 0;
        let mut result = true;
        while i < query.len() && j < pattern.len() {
            if query.chars().nth(i).unwrap() == pattern.chars().nth(j).unwrap() {
                i += 1;
                j += 1;
            } else if query.chars().nth(i).unwrap().is_uppercase() {
                result = false;
                break;
            } else {
                i += 1;
            }
        }
        while i < query.len() && result {
            if query.chars().nth(i).unwrap().is_uppercase() {
                result = false;
            }
            i += 1;
        }
        if j < pattern.len() {
            result = false;
        }
        result
    }
}