impl Solution {
    pub fn string_matching(words: Vec<String>) -> Vec<String> {
        
        let mut res = Vec::new();
        let mut words: Vec<&str> = words.iter().map(|x| x.as_str()).collect();
        words.sort_by_key(|x| x.len());
        for i in 0..words.len() {
            for j in (i + 1)..words.len() {
                if words[j].contains(words[i]) {
                    res.push(words[i]);
                    break;
                }
            }
        }
        res
    }
}