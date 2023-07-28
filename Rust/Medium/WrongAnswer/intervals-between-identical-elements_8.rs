impl Solution {
    pub fn get_distances(arr: Vec<i32>) -> Vec<i64> {
        
        let mut distances = vec![0; arr.len()];
        let mut last_index = vec![None; 100_001];
        for (i, &v) in arr.iter().enumerate() {
            if let Some(last) = last_index[v as usize] {
                distances[i] = distances[last] + i as i64 - last as i64;
            }
            last_index[v as usize] = Some(i);
        }
        distances
    }
    pub fn sum_of_distances_in_array(arr: Vec<i32>) -> Vec<i32> {
        let mut distances = Solution::get_distances(arr.clone());
        let mut rev_distances = Solution::get_distances(arr.into_iter().rev().collect());
        rev_distances.reverse();
        distances
            .into_iter()
            .zip(rev_distances.into_iter())
            .map(|x| (x.0 + x.1) as i32)
            .collect()
    }
}