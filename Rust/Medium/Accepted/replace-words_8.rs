impl Solution {
    pub fn replace_words(dictionary: Vec<String>, sentence: String) -> String {
        

        let mut dict = dictionary;
        dict.sort_by_key(|x| x.len());
        let mut words = sentence.split(' ').collect::<Vec<&str>>();
        let mut res = String::new();
        for word in words {
            let mut flag = false;
            for root in &dict {
                if word.starts_with(root) {
                    res.push_str(root);
                    res.push(' ');
                    flag = true;
                    break;
                }
            }
            if !flag {
                res.push_str(word);
                res.push(' ');
            }
        }
        res.pop();
        res
    }
}