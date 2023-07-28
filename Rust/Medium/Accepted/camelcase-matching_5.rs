impl Solution {
    pub fn camel_match(queries: Vec<String>, pattern: String) -> Vec<bool> {
        
        let mut ans = vec![];
        for q in queries {
            let (mut i, mut j) = (0, 0);
            let mut matched = true;
            while i < q.len() && j < pattern.len() {
                if q.as_bytes()[i] == pattern.as_bytes()[j] {
                    i += 1;
                    j += 1;
                } else if q.as_bytes()[i] >= 65 && q.as_bytes()[i] <= 90 {
                    matched = false;
                    break;
                } else {
                    i += 1;
                }
            }
            if matched {
                while i < q.len() {
                    if q.as_bytes()[i] >= 65 && q.as_bytes()[i] <= 90 {
                        matched = false;
                        break;
                    }
                    i += 1;
                }
            }
            if matched && j < pattern.len() {
                matched = false;
            }
            ans.push(matched);
        }
        ans
    }
}