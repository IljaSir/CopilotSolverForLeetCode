impl Solution {
    pub fn unequal_triplets(nums: Vec<i32>) -> i32 {
        
        let mut c: i32 = 0;
        let mut n = nums.clone();
        n.sort();
        for i in 0..n.len() - 2 {
            for j in i + 1..n.len() - 1 {
                for k in j + 1..n.len() {
                    if n[i] != n[j] && n[j] != n[k] && n[i] != n[k] {
                        c += 1;
                    }
                }
            }
        }
        c
    }
}