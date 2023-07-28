impl Solution {
    pub fn find_and_replace_pattern(words: Vec<String>, pattern: String) -> Vec<String> {
        
        let mut res: Vec<String> = vec![];
        for word in words {
            let mut m1: std::collections::HashMap<char, char> = std::collections::HashMap::new();
            let mut m2: std::collections::HashMap<char, char> = std::collections::HashMap::new();
            let mut flag = true;
            for (i, c) in pattern.chars().enumerate() {
                if m1.contains_key(&c) {
                    if m1[&c] != word.chars().nth(i).unwrap() {
                        flag = false;
                        break;
                    }
                } else {
                    m1.insert(c, word.chars().nth(i).unwrap());
                }
                if m2.contains_key(&word.chars().nth(i).unwrap()) {
                    if m2[&word.chars().nth(i).unwrap()] != c {
                        flag = false;
                        break;
                    }
                } else {
                    m2.insert(word.chars().nth(i).unwrap(), c);
                }
            }
            if flag {
                res.push(word);
            }
        }
        res
    }
}