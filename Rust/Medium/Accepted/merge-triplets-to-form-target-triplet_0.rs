impl Solution {
    pub fn merge_triplets(triplets: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let mut a = 0;
        let mut b = 0;
        let mut c = 0;
        for t in triplets {
            if t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2] {
                a = a.max(t[0]);
                b = b.max(t[1]);
                c = c.max(t[2]);
            }
        }
        a == target[0] && b == target[1] && c == target[2]
    }
}