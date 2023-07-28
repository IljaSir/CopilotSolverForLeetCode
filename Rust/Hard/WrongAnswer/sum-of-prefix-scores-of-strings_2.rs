impl Solution {
    pub fn sum_prefix_scores(words: Vec<String>) -> Vec<i32> {
        
        let mut res = vec![0; words.len()];
        let mut map = std::collections::HashMap::new();
        for (i, word) in words.iter().enumerate() {
            let mut cur = String::new();
            for ch in word.chars() {
                cur.push(ch);
                *map.entry(cur.clone()).or_insert(0) += 1;
                res[i] += map.get(&cur).unwrap();
            }
        }
        res
    }
}