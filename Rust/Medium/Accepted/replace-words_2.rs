impl Solution {
    pub fn replace_words(dictionary: Vec<String>, sentence: String) -> String {
        

        let mut dict = dictionary;
        dict.sort_by(|a, b| a.len().cmp(&b.len()));
        let mut words = sentence.split_whitespace().collect::<Vec<&str>>();
        for word in words.iter_mut() {
            for root in &dict {
                if word.starts_with(root) {
                    *word = root;
                    break;
                }
            }
        }
        words.join(" ")
    }
}