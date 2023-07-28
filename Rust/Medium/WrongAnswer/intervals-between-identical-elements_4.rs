impl Solution {
    pub fn get_distances(arr: Vec<i32>) -> Vec<i64> {
        
        let mut distances: Vec<i64> = vec![0; arr.len()];
        let mut last_seen: Vec<Option<usize>> = vec![None; 100001];
        for i in 0..arr.len() {
            if let Some(j) = last_seen[arr[i] as usize] {
                distances[i] = distances[i] + (i - j) as i64;
                distances[j] = distances[j] + (i - j) as i64;
            }
            last_seen[arr[i] as usize] = Some(i);
        }
        distances
    }
    pub fn sum_of_distances_in_array(arr: Vec<i32>) -> Vec<i32> {
        let distances = Solution::get_distances(arr.clone());
        let mut sums: Vec<i64> = vec![0; arr.len()];
        let mut counts: Vec<i64> = vec![0; arr.len()];
        for i in 0..arr.len() {
            sums[arr[i] as usize] += distances[i];
            counts[arr[i] as usize] += 1;
        }
        let mut result: Vec<i32> = vec![0; arr.len()];
        for i in 0..arr.len() {
            result[i] = (sums[arr[i] as usize] - distances[i]) as i32 / (counts[arr[i] as usize] - 1) as i32;
        }
        result
    }
}