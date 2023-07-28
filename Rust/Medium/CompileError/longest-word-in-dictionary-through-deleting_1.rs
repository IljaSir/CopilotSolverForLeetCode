impl Solution {
    pub fn find_longest_word(s: String, dictionary: Vec<String>) -> String {
        

        let mut dictionary = dictionary;
        dictionary.sort_unstable_by(|a, b| {
            if a.len() == b.len() {
                a.cmp(b)
            } else {
                b.len().cmp(&a.len())
            }
        });
        for word in dictionary {
            if is_subsequence(&s, &word) {
                return word;
            }
        }
        "".to_string()
    }
}