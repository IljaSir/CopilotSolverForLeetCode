impl Solution {
    pub fn two_edit_words(queries: Vec<String>, dictionary: Vec<String>) -> Vec<String> {
        
        let mut res = Vec::new();
        for q in queries {
            for d in &dictionary {
                let mut diff = 0;
                for (i, c) in q.chars().enumerate() {
                    if c != d.chars().nth(i).unwrap() {
                        diff += 1;
                        if diff > 2 {
                            break;
                        }
                    }
                }
                if diff <= 2 {
                    res.push(q);
                    break;
                }
            }
        }
        res
    }
}