impl Solution {
    pub fn array_rank_transform(arr: Vec<i32>) -> Vec<i32> {
        
        let mut result = vec![];
        let mut arr = arr;
        arr.sort();
        let mut map = std::collections::HashMap::new();
        let mut rank = 1;
        for i in 0..arr.len() {
            if !map.contains_key(&arr[i]) {
                map.insert(arr[i], rank);
                rank += 1;
            }
        }
        for i in 0..arr.len() {
            result.push(map[&arr[i]]);
        }
        result
    }
}