impl Solution {
    pub fn most_common_word(paragraph: String, banned: Vec<String>) -> String {
        
        let mut map = std::collections::HashMap::new();
        let mut max = 0;
        let mut res = String::new();
        for word in paragraph.split(|c: char| !c.is_alphabetic()).map(|s| s.to_lowercase()) {
            if word.is_empty() || banned.contains(&word) {
                continue;
            }
            let counter = map.entry(word).or_insert(0);
            *counter += 1;
            if *counter > max {
                max = *counter;
                res = map.iter().find(|&(_, v)| *v == max).unwrap().0.to_string();
            }
        }
        res
    }
}