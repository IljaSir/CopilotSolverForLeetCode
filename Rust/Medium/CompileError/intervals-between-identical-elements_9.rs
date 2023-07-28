impl Solution {
    pub fn get_distances(arr: Vec<i32>) -> Vec<i64> {
        
        let mut index_map = std::collections::HashMap::new();
        let mut result = vec![0; arr.len()];
        for (i, &n) in arr.iter().enumerate() {
            let mut count = 0;
            if let Some(v) = index_map.get(&n) {
                for j in v.iter() {
                    result[i] += (i as i64 - *j as i64).abs();
                    result[*j as usize] += (i as i64 - *j as i64).abs();
                    count += 1;
                }
            }
            index_map.entry(n).or_insert(vec![]).push(i as i32);
        }
        result
    }
}