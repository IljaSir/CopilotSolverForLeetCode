impl Solution {
    pub fn target_indices(nums: Vec<i32>, target: i32) -> Vec<i32> {
        
        let mut v = vec![];
        for (i, x) in nums.iter().enumerate() {
            if *x == target {
                v.push(i as i32);
            }
        }
        v
    }
}