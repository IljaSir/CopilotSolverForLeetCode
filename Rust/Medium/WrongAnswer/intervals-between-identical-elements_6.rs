impl Solution {
    pub fn get_distances(arr: Vec<i32>) -> Vec<i64> {
        
        let mut counts = vec![0; 100001];
        let mut sums = vec![0; 100001];
        let mut distances = vec![0; arr.len()];
        for i in 0..arr.len() {
            let v = arr[i] as usize;
            distances[i] = sums[v];
            sums[v] += counts[v] * i as i64 - distances[i];
            counts[v] += 1;
        }
        distances
    }
    pub fn sum_of_distances_in_array(arr: Vec<i32>) -> Vec<i32> {
        let mut distances = Solution::get_distances(arr.clone());
        let mut distances_rev = Solution::get_distances(arr.into_iter().rev().collect());
        distances_rev.reverse();
        for i in 0..distances.len() {
            distances[i] += distances_rev[i];
        }
        distances.into_iter().map(|v| v as i32).collect()
    }
}