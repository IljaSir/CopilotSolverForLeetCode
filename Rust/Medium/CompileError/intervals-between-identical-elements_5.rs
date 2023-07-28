impl Solution {
    pub fn get_distances(arr: Vec<i32>) -> Vec<i64> {
        
        let mut res = vec![0; arr.len()];
        let mut map = std::collections::HashMap::new();
        for (i, &v) in arr.iter().enumerate() {
            if let Some(&j) = map.get(&v) {
                res[i] = res[i-1] + (i as i64 - j as i64);
            } else {
                res[i] = res[i-1];
            }
            map.insert(v, i);
        }
        res
    }
    pub fn get_sum_of_intervals(arr: Vec<i32>) -> Vec<i64> {
        let mut res = vec![0; arr.len()];
        let mut map = std::collections::HashMap::new();
        for (i, &v) in arr.iter().enumerate() {
            if let Some(&j) = map.get(&v) {
                res[i] = res[i-1] + (i as i64 - j as i64) - (j as i64 - map.get(&v).unwrap_or(&0) as i64);
            } else {
                res[i] = res[i-1];
            }
            map.insert(v, i);
        }
        res
    }
    pub fn sum_of_distances_in_array(arr: Vec<i32>) -> Vec<i32> {
        let mut forward = Self::get_distances(arr.clone());
        let mut backward = Self::get_distances(arr.iter().rev().cloned().collect());
        backward.reverse();
        let mut res = vec![0; arr.len()];
        for (i, &v) in arr.iter().enumerate() {
            res[i] = (forward[i] + backward[i]) as i32;
        }
        res
    }
}