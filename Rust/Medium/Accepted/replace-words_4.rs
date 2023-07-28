impl Solution {
    pub fn replace_words(dictionary: Vec<String>, sentence: String) -> String {
        

        let mut dict = std::collections::HashSet::new();
        for s in dictionary {
            dict.insert(s);
        }
        let mut ans = Vec::new();
        for word in sentence.split_whitespace() {
            let mut prefix = String::new();
            for c in word.chars() {
                prefix.push(c);
                if dict.contains(&prefix) {
                    break;
                }
            }
            ans.push(prefix);
        }
        ans.join(" ")
    }
}