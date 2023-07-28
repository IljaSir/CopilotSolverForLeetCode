impl Solution {
    pub fn merge_triplets(triplets: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let mut t = vec![0; 3];
        for t1 in triplets {
            if t1[0] > target[0] || t1[1] > target[1] || t1[2] > target[2] {
                continue;
            }
            for i in 0..3 {
                t[i] = t[i].max(t1[i]);
            }
        }
        t == target
    }
}