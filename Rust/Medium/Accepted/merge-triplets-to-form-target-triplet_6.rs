impl Solution {
    pub fn merge_triplets(triplets: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let mut max = vec![0,0,0];
        for triplet in triplets {
            if triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2] {
                max[0] = max[0].max(triplet[0]);
                max[1] = max[1].max(triplet[1]);
                max[2] = max[2].max(triplet[2]);
            }
        }
        max == target
    }
}