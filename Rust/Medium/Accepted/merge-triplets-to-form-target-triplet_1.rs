impl Solution {
    pub fn merge_triplets(triplets: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let mut a = 0;
        let mut b = 0;
        let mut c = 0;
        for triplet in triplets {
            if triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2] {
                a = std::cmp::max(a, triplet[0]);
                b = std::cmp::max(b, triplet[1]);
                c = std::cmp::max(c, triplet[2]);
            }
        }
        a == target[0] && b == target[1] && c == target[2]
    }
}