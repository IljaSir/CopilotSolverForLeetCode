impl Solution {
    pub fn replace_words(dictionary: Vec<String>, sentence: String) -> String {
        

        let mut dict = std::collections::HashSet::new();
        for i in dictionary {
            dict.insert(i);
        }
        let mut res = String::new();
        for word in sentence.split(" ") {
            for i in 1..word.len() {
                if dict.contains(&word[..i]) {
                    res.push_str(&word[..i]);
                    res.push(' ');
                    break;
                }
            }
        }
        res.pop();
        res
    }
}