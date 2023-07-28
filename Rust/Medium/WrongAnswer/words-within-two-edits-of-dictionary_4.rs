impl Solution {
    pub fn two_edit_words(queries: Vec<String>, dictionary: Vec<String>) -> Vec<String> {
        
        let mut res = Vec::new();
        for q in &queries {
            let mut is_found = false;
            for d in &dictionary {
                if q == d {
                    res.push(q.clone());
                    is_found = true;
                    break;
                }
                if q.len() == d.len() {
                    if Self::check_one_edit(q, d) {
                        res.push(q.clone());
                        is_found = true;
                        break;
                    }
                } else if q.len() == d.len() + 1 {
                    if Self::check_one_delete(q, d) {
                        res.push(q.clone());
                        is_found = true;
                        break;
                    }
                } else if q.len() + 1 == d.len() {
                    if Self::check_one_delete(d, q) {
                        res.push(q.clone());
                        is_found = true;
                        break;
                    }
                }
            }
            if !is_found {
                res.push(q.clone());
            }
        }
        res
    }
    fn check_one_edit(word1: &str, word2: &str) -> bool {
        let mut is_found = false;
        for i in 0..word1.len() {
            let mut s = word1.to_string();
            s.remove(i);
            if s == word2 {
                if is_found {
                    return false;
                }
                is_found = true;
            }
        }
        is_found
    }
    fn check_one_delete(word1: &str, word2: &str) -> bool {
        let mut is_found = false;
        for i in 0..word1.len() {
            let mut s = word1.to_string();
            s.remove(i);
            if s == word2 {
                if is_found {
                    return false;
                }
                is_found = true;
            }
        }
        is_found
    }
}