impl Solution {
    pub fn create_target_array(nums: Vec<i32>, index: Vec<i32>) -> Vec<i32> {
        
        let mut target: Vec<i32> = Vec::new();
        for (i, n) in nums.iter().enumerate() {
            target.insert(index[i] as usize, *n);
        }
        target
    }
}