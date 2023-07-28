impl Solution {
    pub fn top_k_frequent(words: Vec<String>, k: i32) -> Vec<String> {
        

        use std::collections::HashMap;
        let mut map = HashMap::new();
        for word in words {
            *map.entry(word).or_insert(0) += 1;
        }
        let mut heap = std::collections::BinaryHeap::new();
        for (word, count) in map {
            heap.push((count, word));
        }
        let mut result = Vec::with_capacity(k as usize);
        for _ in 0..k {
            let (count, word) = heap.pop().unwrap();
            result.push(word);
        }
        result
    }
}