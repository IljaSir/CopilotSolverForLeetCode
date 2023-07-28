impl Solution {
    pub fn find_and_replace_pattern(words: Vec<String>, pattern: String) -> Vec<String> {
        
        let mut result:Vec<String> = Vec::new();
        for word in words {
            let mut map:std::collections::HashMap<char, char> = std::collections::HashMap::new();
            let mut used:std::collections::HashSet<char> = std::collections::HashSet::new();
            let mut flag = true;
            for (i, ch) in pattern.chars().enumerate() {
                let wch = word.chars().nth(i).unwrap();
                if let Some(&c) = map.get(&ch) {
                    if c != wch {
                        flag = false;
                        break;
                    }
                } else {
                    if used.contains(&wch) {
                        flag = false;
                        break;
                    }
                    map.insert(ch, wch);
                    used.insert(wch);
                }
            }
            if flag {
                result.push(word);
            }
        }
        result
    }
}