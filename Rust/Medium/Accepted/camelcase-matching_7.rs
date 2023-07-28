impl Solution {
    pub fn camel_match(queries: Vec<String>, pattern: String) -> Vec<bool> {
        
        let mut result = vec![];
        for q in queries {
            let mut i = 0;
            let mut j = 0;
            let mut match_flag = true;
            while i < q.len() {
                if j < pattern.len() && q.as_bytes()[i] == pattern.as_bytes()[j] {
                    i += 1;
                    j += 1;
                } else if q.as_bytes()[i] >= 65 && q.as_bytes()[i] <= 90 {
                    match_flag = false;
                    break;
                } else {
                    i += 1;
                }
            }
            if j != pattern.len() {
                match_flag = false;
            }
            result.push(match_flag);
        }
        result
    }
}