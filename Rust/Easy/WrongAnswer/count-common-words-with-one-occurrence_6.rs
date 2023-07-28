impl Solution {
    pub fn count_words(words1: Vec<String>, words2: Vec<String>) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for word in &words1 {
            *map.entry(word).or_insert(0) += 1;
        }
        for word in &words2 {
            *map.entry(word).or_insert(0) += 1;
        }
        for (_, v) in map {
            if v == 1 {
                count += 1;
            }
        }
        count
    }
}