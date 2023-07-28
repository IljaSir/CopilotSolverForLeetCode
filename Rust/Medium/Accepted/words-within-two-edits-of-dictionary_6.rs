impl Solution {
    pub fn two_edit_words(queries: Vec<String>, dictionary: Vec<String>) -> Vec<String> {
        
        let mut result = vec![];
        for query in queries {
            for dict in dictionary.clone() {
                if Self::is_two_edits(&query, &dict) {
                    result.push(query.clone());
                    break;
                }
            }
        }
        result
    }
    fn is_two_edits(a: &str, b: &str) -> bool {
        let mut diffs = 0;
        let mut i = 0;
        let mut j = 0;
        while i < a.len() && j < b.len() {
            if a.as_bytes()[i] != b.as_bytes()[j] {
                diffs += 1;
                if diffs > 2 {
                    return false;
                }
                if a.len() > b.len() {
                    i += 1;
                } else if a.len() < b.len() {
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
        diffs <= 2
    }
}