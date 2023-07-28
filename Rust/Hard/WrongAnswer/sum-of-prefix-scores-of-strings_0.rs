impl Solution {
    pub fn sum_prefix_scores(words: Vec<String>) -> Vec<i32> {
        
        let mut res = vec![0; words.len()];
        let mut map = std::collections::HashMap::new();
        for (i, word) in words.iter().enumerate() {
            let mut prefix = String::new();
            for c in word.chars() {
                prefix.push(c);
                if let Some(v) = map.get_mut(&prefix) {
                    *v += 1;
                } else {
                    map.insert(prefix.clone(), 1);
                }
                res[i] += 1;
            }
        }
        res
    }
}