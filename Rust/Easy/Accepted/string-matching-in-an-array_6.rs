impl Solution {
    pub fn string_matching(words: Vec<String>) -> Vec<String> {
        
        let mut res = Vec::new();
        let mut words = words;
        words.sort_by(|a, b| a.len().cmp(&b.len()));
        for i in 0..words.len() {
            for j in i + 1..words.len() {
                if words[j].contains(&words[i]) {
                    res.push(words[i].clone());
                    break;
                }
            }
        }
        res
    }
}