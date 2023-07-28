impl Solution {
    pub fn similar_pairs(words: Vec<String>) -> i32 {
        
        let mut res = 0;
        for i in 0..words.len() {
            for j in i+1..words.len() {
                let mut word1 = words[i].clone();
                let mut word2 = words[j].clone();
                word1.sort();
                word2.sort();
                if word1 == word2 {
                    res += 1;
                }
            }
        }
        res
    }
}