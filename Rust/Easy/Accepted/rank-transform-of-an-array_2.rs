impl Solution {
    pub fn array_rank_transform(arr: Vec<i32>) -> Vec<i32> {
        
        let mut arr = arr;
        let mut sorted_arr = arr.clone();
        sorted_arr.sort();
        let mut rank = 1;
        let mut rank_map = std::collections::HashMap::new();
        for i in 0..sorted_arr.len() {
            if !rank_map.contains_key(&sorted_arr[i]) {
                rank_map.insert(sorted_arr[i], rank);
                rank += 1;
            }
        }

        for i in 0..arr.len() {
            arr[i] = rank_map[&arr[i]];
        }
        arr
    }
}