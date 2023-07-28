impl Solution {
    pub fn sort_sentence(s: String) -> String {
        
        let mut words = s.split(" ");
        let mut ret = vec![];
        while let Some(word) = words.next() {
            let mut chars = word.chars();
            let mut num = 0;
            while let Some(c) = chars.next() {
                if c.is_digit(10) {
                    num = c.to_digit(10).unwrap();
                } else {
                    ret.push((num, c.to_string()));
                }
            }
        }
        ret.sort_by(|a, b| a.0.cmp(&b.0));
        let mut result = String::new();
        for (_, word) in ret {
            result.push_str(&word);
            result.push(' ');
        }
        result.pop();
        result
    }
}