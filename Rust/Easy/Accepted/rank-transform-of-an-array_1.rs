impl Solution {
    pub fn array_rank_transform(arr: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![0; arr.len()];
        let mut sorted = arr.clone();
        sorted.sort();
        let mut map = std::collections::HashMap::new();
        let mut rank = 1;
        for i in 0..sorted.len() {
            if !map.contains_key(&sorted[i]) {
                map.insert(sorted[i], rank);
                rank += 1;
            }
        }
        for i in 0..arr.len() {
            res[i] = map[&arr[i]];
        }
        res
    }
}