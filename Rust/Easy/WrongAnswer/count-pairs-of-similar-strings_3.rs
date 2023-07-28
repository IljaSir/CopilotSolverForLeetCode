impl Solution {
    pub fn similar_pairs(words: Vec<String>) -> i32 {
        
        let mut count = 0;
        for i in 0..words.len() {
            for j in (i+1)..words.len() {
                if words[i].len() == words[j].len() {
                    let mut diff = 0;
                    for k in 0..words[i].len() {
                        if words[i].chars().nth(k).unwrap() != words[j].chars().nth(k).unwrap() {
                            diff += 1;
                        }
                        if diff > 2 {
                            break;
                        }
                    }
                    if diff == 2 {
                        count += 1;
                    }
                }
            }
        }
        count
    }
}