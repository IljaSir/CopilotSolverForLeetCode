impl Solution {
    pub fn string_matching(words: Vec<String>) -> Vec<String> {
        
        let mut res = Vec::new();
        for i in 0..words.len() {
            for j in 0..words.len() {
                if i == j { continue; }
                if words[i].contains(&words[j]) {
                    res.push(words[j].clone());
                }
            }
        }
        res
    }
}