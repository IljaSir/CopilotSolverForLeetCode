impl Solution {
    pub fn string_matching(words: Vec<String>) -> Vec<String> {
        
        let mut result = Vec::new();
        for i in 0..words.len() {
            for j in 0..words.len() {
                if i != j && words[i].contains(&words[j]) {
                    result.push(words[j].to_owned());
                }
            }
        }
        result.sort();
        result.dedup();
        result
    }
}