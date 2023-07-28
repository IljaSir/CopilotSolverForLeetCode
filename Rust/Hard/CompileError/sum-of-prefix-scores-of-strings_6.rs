impl Solution {
    pub fn sum_prefix_scores(words: Vec<String>) -> Vec<i32> {
        
        let mut result = vec![0; words.len()];
        let mut map: HashMap<String, i32> = HashMap::new();
        for i in 0..words.len() {
            let mut word = String::new();
            for ch in words[i].chars() {
                word.push(ch);
                *map.entry(word.clone()).or_insert(0) += 1;
            }
        }
        for i in 0..words.len() {
            let mut word = String::new();
            for ch in words[i].chars() {
                word.push(ch);
                result[i] += map.get(&word).unwrap();
            }
        }
        result
    }
}