impl Solution {
    pub fn common_chars(words: Vec<String>) -> Vec<String> {
        
        let mut res = Vec::new();
        let mut map = words[0].chars().fold(std::collections::HashMap::new(), |mut map, c| {
            *map.entry(c).or_insert(0) += 1;
            map
        });
        for word in words.iter().skip(1) {
            let mut map2 = std::collections::HashMap::new();
            for c in word.chars() {
                if let Some(count) = map.get(&c) {
                    if *count > 0 {
                        *map2.entry(c).or_insert(0) += 1;
                    }
                }
            }
            map = map2;
        }
        for (c, count) in map {
            for _ in 0..count {
                res.push(c.to_string());
            }
        }
        res
    }
}