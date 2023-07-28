impl Solution {
    pub fn get_distances(arr: Vec<i32>) -> Vec<i64> {
        
        let mut map: std::collections::HashMap<i32, Vec<usize>> = std::collections::HashMap::new();
        for (i, v) in arr.iter().enumerate() {
            map.entry(*v).or_insert(Vec::new()).push(i);
        }
        let mut result: Vec<i64> = Vec::new();
        for (i, v) in arr.iter().enumerate() {
            let mut sum: i64 = 0;
            for j in map.get(v).unwrap() {
                sum += (i as i64 - *j as i64).abs();
            }
            result.push(sum);
        }
        result
    }
}