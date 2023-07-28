impl Solution {
    pub fn two_edit_words(queries: Vec<String>, dictionary: Vec<String>) -> Vec<String> {
        
        let mut res = vec![];
        for q in queries {
            for d in &dictionary {
                if Solution::is_two_edit_words(&q, d) {
                    res.push(q.clone());
                    break;
                }
            }
        }
        res
    }
    
    fn is_two_edit_words(q: &str, d: &str) -> bool {
        if q == d {
            return true;
        }
        let mut i = 0;
        let mut j = 0;
        let mut diff = 0;
        while i < q.len() && j < d.len() {
            if q.as_bytes()[i] != d.as_bytes()[j] {
                if diff == 1 {
                    return false;
                }
                if q.len() > d.len() {
                    i += 1;
                } else if q.len() < d.len() {
                    j += 1;
                } else {
                    i += 1;
                    j += 1;
                }
                diff += 1;
            } else {
                i += 1;
                j += 1;
            }
        }
        diff <= 1
    }
}