impl Solution {
    pub fn similar_pairs(words: Vec<String>) -> i32 {
        
        let mut count = 0;
        for i in 0..words.len() {
            for j in i+1..words.len() {
                if words[i].len() != words[j].len() {
                    continue;
                }
                let mut diff = 0;
                for (a, b) in words[i].chars().zip(words[j].chars()) {
                    if a != b {
                        diff += 1;
                    }
                    if diff > 2 {
                        break;
                    }
                }
                if diff == 2 || diff == 0 {
                    count += 1;
                }
            }
        }
        count
    }
}