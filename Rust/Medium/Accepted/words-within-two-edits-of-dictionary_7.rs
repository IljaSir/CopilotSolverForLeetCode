impl Solution {
    pub fn two_edit_words(queries: Vec<String>, dictionary: Vec<String>) -> Vec<String> {
        
        let mut result: Vec<String> = Vec::new();
        for query in queries {
            let mut found = false;
            for word in &dictionary {
                if Self::within_two_edits(query.as_bytes(), word.as_bytes()) {
                    found = true;
                    break;
                }
            }
            if found {
                result.push(query);
            }
        }
        result
    }
    
    fn within_two_edits(a: &[u8], b: &[u8]) -> bool {
        let mut i = 0;
        let mut j = 0;
        let mut edits = 0;
        while i < a.len() && j < b.len() {
            if a[i] != b[j] {
                edits += 1;
                if edits > 2 {
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
        edits + (a.len() - i) + (b.len() - j) <= 2
    }
}