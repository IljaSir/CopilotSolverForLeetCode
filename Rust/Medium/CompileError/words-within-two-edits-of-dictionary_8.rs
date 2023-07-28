impl Solution {
    pub fn two_edit_words(queries: Vec<String>, dictionary: Vec<String>) -> Vec<String> {
        
        let mut res: Vec<String> = Vec::new();
        for q in queries {
            for d in &dictionary {
                if q.len() == d.len() && q != *d {
                    if Solution::one_edit_word(q.clone(), d.clone()) {
                        res.push(q.clone());
                        break;
                    }
                } else if q.len() + 1 == d.len() {
                    if Solution::one_edit_word(q.clone(), d.clone()) {
                        res.push(q.clone());
                        break;
                    }
                } else if q.len() == d.len() + 1 {
                    if Solution::one_edit_word(q.clone(), d.clone()) {
                        res.push(q.clone());
                        break;
                    }
                }
            }
        }
        res
    }
    fn one_edit_word(query: String, dict: String) -> bool {
        let (mut i, mut j) = (0, 0);
        let (mut diff, mut count) = (0, 0);
        while i < query.len() && j < dict.len() {
            if query.chars().nth(i).unwrap() != dict.chars().nth(j).unwrap() {
                diff = i - j;
                count += 1;
                if count > 2 {
                    return false;
                }
            }
            i += 1;
            j += 1;
            if diff == 1 {
                j += 1;
            } else if diff == -1 {
                i += 1;
            }
        }
        true
    }
}