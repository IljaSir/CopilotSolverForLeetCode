impl Solution {
    pub fn string_matching(words: Vec<String>) -> Vec<String> {
        
        let mut result = vec![];
        let words = words.iter().map(|s| s.as_str()).collect::<Vec<_>>();
        for i in 0..words.len() {
            for j in 0..words.len() {
                if i == j {
                    continue;
                }
                if words[i].len() > words[j].len() {
                    continue;
                }
                if words[j].contains(words[i]) {
                    result.push(words[i].to_string());
                    break;
                }
            }
        }
        result
    }
}