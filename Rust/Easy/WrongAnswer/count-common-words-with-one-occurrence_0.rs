impl Solution {
    pub fn count_words(words1: Vec<String>, words2: Vec<String>) -> i32 {
        
        let mut map1 = std::collections::HashMap::new();
        let mut map2 = std::collections::HashMap::new();
        for word in words1 {
            *map1.entry(word).or_insert(0) += 1;
        }
        for word in words2 {
            *map2.entry(word).or_insert(0) += 1;
        }
        let mut count = 0;
        for (word, times) in map1.iter() {
            if *times == 1 && map2.contains_key(word) && map2[word] == 1 {
                count += 1;
            }
        }
        for (word, times) in map2.iter() {
            if *times == 1 && map1.contains_key(word) && map1[word] == 1 {
                count += 1;
            }
        }
        count
    }
}