impl Solution {
    pub fn sum_prefix_scores(words: Vec<String>) -> Vec<i32> {
        
        let mut ans = vec![0; words.len()];
        let mut map = std::collections::HashMap::new();
        for (i, word) in words.iter().enumerate() {
            let mut s = String::new();
            for c in word.chars() {
                s.push(c);
                *map.entry(s.clone()).or_insert(0) += 1;
                ans[i] += map[&s];
            }
        }
        ans
    }
}