impl Solution {
    pub fn similar_pairs(words: Vec<String>) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for (i, word) in words.iter().enumerate() {
            let mut sorted = word.chars().collect::<Vec<_>>();
            sorted.sort();
            for (j, c) in sorted.iter().enumerate() {
                if let Some(pair) = map.get_mut(c) {
                    count += pair.len();
                    for k in 0..j {
                        pair.push((i, sorted[k]));
                    }
                } else {
                    map.insert(*c, vec![(i, sorted[j])]);
                }
            }
        }
        count
    }
}