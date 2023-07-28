impl Solution {
    pub fn get_distances(arr: Vec<i32>) -> Vec<i64> {
        
        let mut map = std::collections::HashMap::new();
        for (i, v) in arr.iter().enumerate() {
            map.entry(v).or_insert_with(|| vec![]).push(i as i64);
        }
        let mut res = vec![0; arr.len()];
        for v in map.values() {
            for i in 0..v.len() {
                for j in i + 1..v.len() {
                    res[v[i] as usize] += v[j] - v[i];
                    res[v[j] as usize] += v[j] - v[i];
                }
            }
        }
        res
    }
}