impl Solution {
    pub fn find_and_replace_pattern(words: Vec<String>, pattern: String) -> Vec<String> {
        
        let mut result = Vec::new();
        let p = pattern.chars().collect::<Vec<char>>();
        for word in words {
            let w = word.chars().collect::<Vec<char>>();
            let mut map = HashMap::new();
            let mut is_match = true;
            for i in 0..p.len() {
                if !map.contains_key(&p[i]) {
                    if !map.values().any(|&v| v == w[i]) {
                        map.insert(p[i], w[i]);
                    } else {
                        is_match = false;
                        break;
                    }
                } else {
                    if *map.get(&p[i]).unwrap() != w[i] {
                        is_match = false;
                        break;
                    }
                }
            }
            if is_match {
                result.push(word);
            }
        }
        result
    }
}