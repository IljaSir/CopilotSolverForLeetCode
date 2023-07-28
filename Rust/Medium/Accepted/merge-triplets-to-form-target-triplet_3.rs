impl Solution {
    pub fn merge_triplets(triplets: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let mut max = vec![0, 0, 0];
        for t in triplets {
            if t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2] {
                max[0] = max[0].max(t[0]);
                max[1] = max[1].max(t[1]);
                max[2] = max[2].max(t[2]);
            }
        }
        max == target
    }
}