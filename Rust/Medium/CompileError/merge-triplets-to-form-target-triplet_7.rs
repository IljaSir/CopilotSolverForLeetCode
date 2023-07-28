impl Solution {
    pub fn merge_triplets(triplets: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let mut t = target;
        for t1 in triplets {
            if t1[0] <= t[0] && t1[1] <= t[1] && t1[2] <= t[2] {
                t[0] = t[0].min(t1[0]);
                t[1] = t[1].min(t1[1]);
                t[2] = t[2].min(t1[2]);
            }
        }
        t == target
    }
}