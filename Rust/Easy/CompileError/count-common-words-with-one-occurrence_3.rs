impl Solution {
    pub fn count_words(words1: Vec<String>, words2: Vec<String>) -> i32 {
        
        let mut map1 = std::collections::HashMap::new();
        let mut map2 = std::collections::HashMap::new();
        for w in words1 {
            *map1.entry(w).or_insert(0) += 1;
        }
        for w in words2 {
            *map2.entry(w).or_insert(0) += 1;
        }
        let mut ans = 0;
        for (k, v) in map1 {
            if v == 1 && map2.get(&k).is_some() {
                ans += 1;
            }
        }
        for (k, v) in map2 {
            if v == 1 && map1.get(&k).is_some() {
                ans += 1;
            }
        }
        ans
    }
}