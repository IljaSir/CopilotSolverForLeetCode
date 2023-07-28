impl Solution {
    pub fn replace_words(dictionary: Vec<String>, sentence: String) -> String {
        

        let mut dictionary = dictionary;
        dictionary.sort_by_key(|s| s.len());
        let mut words = sentence.split(' ').collect::<Vec<_>>();
        for i in 0..words.len() {
            for j in 0..dictionary.len() {
                if words[i].starts_with(&dictionary[j]) {
                    words[i] = &dictionary[j];
                    break;
                }
            }
        }
        words.join(" ")
    }
}