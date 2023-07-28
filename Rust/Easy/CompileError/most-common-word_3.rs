impl Solution {
    pub fn most_common_word(paragraph: String, banned: Vec<String>) -> String {
        
        let mut map: HashMap<String, i32> = HashMap::new();
        for word in paragraph.split(|c: char| !c.is_alphanumeric()).map(|s| s.to_lowercase()) {
            if word.len() > 0 && !banned.contains(&word) {
                *map.entry(word).or_insert(0) += 1;
            }
        }
        let mut max = 0;
        let mut res = "".to_string();
        for (k, v) in map {
            if v > max {
                max = v;
                res = k;
            }
        }
        res
    }
}