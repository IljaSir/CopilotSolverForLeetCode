impl Solution {
    pub fn most_common_word(paragraph: String, banned: Vec<String>) -> String {
        
        let mut map: HashMap<String, i32> = HashMap::new();
        let mut max = 0;
        let mut ans = String::new();
        for c in paragraph.chars() {
            if !c.is_alphabetic() {
                map.insert(c.to_string(), -1);
            }
        }
        for word in paragraph.split(|c: char| !c.is_alphabetic()) {
            if word.len() == 0 {
                continue;
            }
            let word = word.to_lowercase();
            if !banned.contains(&word) {
                let count = map.entry(word).or_insert(0);
                *count += 1;
                if *count > max {
                    max = *count;
                    ans = count.to_string();
                }
            }
        }
        ans
    }
}