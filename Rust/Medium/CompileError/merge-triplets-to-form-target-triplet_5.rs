impl Solution {
    pub fn merge_triplets(triplets: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let mut t = target;
        for v in triplets {
            if v[0] <= t[0] && v[1] <= t[1] && v[2] <= t[2] {
                t[0] = t[0].min(v[0]);
                t[1] = t[1].min(v[1]);
                t[2] = t[2].min(v[2]);
            }
        }
        t == target
    }
}