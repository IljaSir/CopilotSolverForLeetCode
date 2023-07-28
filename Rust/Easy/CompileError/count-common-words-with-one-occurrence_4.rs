impl Solution {
    pub fn count_words(words1: Vec<String>, words2: Vec<String>) -> i32 {
        
        let mut m1 = std::collections::HashMap::new();
        let mut m2 = std::collections::HashMap::new();
        for word in &words1 {
            *m1.entry(word).or_insert(0) += 1;
        }
        for word in &words2 {
            *m2.entry(word).or_insert(0) += 1;
        }
        let mut count = 0;
        for (k, v) in m1 {
            if v == 1 && m2.contains_key(&k) {
                count += 1;
            }
        }
        for (k, v) in m2 {
            if v == 1 && m1.contains_key(&k) {
                count += 1;
            }
        }
        count
    }
}