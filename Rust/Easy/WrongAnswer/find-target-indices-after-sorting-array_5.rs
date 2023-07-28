impl Solution {
    pub fn target_indices(nums: Vec<i32>, target: i32) -> Vec<i32> {
        
        let mut sorted = nums.clone();
        sorted.sort();
        let mut res = Vec::new();
        for (i, &v) in sorted.iter().enumerate() {
            if v == target {
                res.push(nums.iter().position(|&x| x == v).unwrap() as i32);
            }
        }
        res
    }
}