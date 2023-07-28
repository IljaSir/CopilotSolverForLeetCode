impl Solution {
    pub fn common_chars(words: Vec<String>) -> Vec<String> {
        
        let mut res = Vec::new();
        let mut chars = words[0].chars().collect::<Vec<char>>();
        for i in 1..words.len() {
            let mut tmp = Vec::new();
            for c in words[i].chars() {
                if let Some(index) = chars.iter().position(|&x| x == c) {
                    tmp.push(chars.remove(index));
                }
            }
            chars = tmp;
        }
        for c in chars {
            res.push(c.to_string());
        }
        res
    }
}