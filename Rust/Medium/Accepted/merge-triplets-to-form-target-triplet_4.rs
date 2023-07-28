impl Solution {
    pub fn merge_triplets(triplets: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let mut t = vec![0; 3];
        for triplet in triplets {
            if triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2] {
                t[0] = t[0].max(triplet[0]);
                t[1] = t[1].max(triplet[1]);
                t[2] = t[2].max(triplet[2]);
            }
        }
        t == target
    }
}