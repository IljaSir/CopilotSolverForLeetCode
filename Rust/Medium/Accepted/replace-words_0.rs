impl Solution {
    pub fn replace_words(dictionary: Vec<String>, sentence: String) -> String {
        

        let mut dict: Vec<String> = dictionary;
        dict.sort_by(|a, b| a.len().cmp(&b.len()));
        let mut words: Vec<String> = sentence.split_whitespace().map(|s| s.to_string()).collect();
        for i in 0..words.len() {
            for j in 0..dict.len() {
                if words[i].starts_with(&dict[j]) {
                    words[i] = dict[j].clone();
                    break;
                }
            }
        }
        words.join(" ")
    }
}