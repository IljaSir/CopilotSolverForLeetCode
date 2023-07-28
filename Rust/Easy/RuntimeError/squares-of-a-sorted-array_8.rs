impl Solution {
    pub fn sorted_squares(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut i = 0;
        let mut j = nums.len() - 1;
        while i <= j {
            let num_i = nums[i] * nums[i];
            let num_j = nums[j] * nums[j];
            if num_i > num_j {
                result.insert(0, num_i);
                i += 1;
            } else {
                result.insert(0, num_j);
                j -= 1;
            }
        }
        result
    }
}