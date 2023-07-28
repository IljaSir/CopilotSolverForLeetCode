impl Solution {
    pub fn replace_words(dictionary: Vec<String>, sentence: String) -> String {
        

        let mut d = dictionary;
        d.sort_by(|a, b| a.len().cmp(&b.len()));
        let mut res = Vec::new();
        for word in sentence.split(" ") {
            let mut found = false;
            for root in d.iter() {
                if word.starts_with(root) {
                    res.push(root.to_string());
                    found = true;
                    break;
                }
            }
            if !found {
                res.push(word.to_string());
            }
        }
        res.join(" ")
    }
}