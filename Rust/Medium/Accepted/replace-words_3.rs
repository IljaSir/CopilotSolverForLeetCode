impl Solution {
    pub fn replace_words(dictionary: Vec<String>, sentence: String) -> String {
        

        let mut dict = std::collections::HashSet::new();
        for s in dictionary {
            dict.insert(s);
        }
        let mut res = String::new();
        for word in sentence.split(' ') {
            let mut w = String::new();
            for c in word.chars() {
                w.push(c);
                if dict.contains(&w) {
                    break;
                }
            }
            res.push_str(&w);
            res.push(' ');
        }
        res.pop();
        res
    }
}