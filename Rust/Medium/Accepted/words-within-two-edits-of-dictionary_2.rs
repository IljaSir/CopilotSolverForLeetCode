impl Solution {
    pub fn two_edit_words(queries: Vec<String>, dictionary: Vec<String>) -> Vec<String> {
        
        let mut result = Vec::new();
        for q in queries {
            for d in &dictionary {
                if Solution::is_two_edits(&q, d) {
                    result.push(q.clone());
                    break;
                }
            }
        }
        result
    }
    fn is_two_edits(s: &str, t: &str) -> bool {
        let mut i = 0;
        let mut j = 0;
        let mut diff = 0;
        while i < s.len() && j < t.len() {
            if s.as_bytes()[i] != t.as_bytes()[j] {
                diff += 1;
                if diff > 2 {
                    return false;
                }
                if s.len() > t.len() {
                    i += 1;
                } else if s.len() < t.len() {
                    j += 1;
                } else {
                    i += 1;
                    j += 1;
                }
            } else {
                i += 1;
                j += 1;
            }
        }
        true
    }
}