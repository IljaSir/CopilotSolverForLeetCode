impl Solution {
    pub fn count_words(words1: Vec<String>, words2: Vec<String>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for w in words1 {
            let count = map.entry(w).or_insert(0);
            *count += 1;
        }
        for w in words2 {
            let count = map.entry(w).or_insert(0);
            *count += 1;
        }
        map.values().filter(|v| **v == 1).count() as i32
    }
}