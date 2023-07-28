impl Solution {
    pub fn second_greater_element(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = Vec::with_capacity(nums.len());
        for i in 0..nums.len() {
            let mut j = i + 1;
            while j < nums.len() {
                if nums[j] > nums[i] {
                    result.push(nums[j]);
                    break;
                }
                j += 1;
            }
            if j == nums.len() {
                result.push(-1);
            }
        }
        result
    }
}