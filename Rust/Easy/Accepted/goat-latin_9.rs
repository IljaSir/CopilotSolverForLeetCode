impl Solution {
    pub fn to_goat_latin(sentence: String) -> String {
        
        let mut res = String::new();
        let mut i = 1;
        for word in sentence.split_whitespace() {
            let mut w = String::from(word);
            if "aeiouAEIOU".contains(&w[..1]) {
                w.push_str("ma");
            } else {
                let c = w.remove(0);
                w.push(c);
                w.push_str("ma");
            }
            w.push_str(&"a".repeat(i));
            i += 1;
            res.push_str(&w);
            res.push(' ');
        }
        res.pop();
        res
    }
}