impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut candidate = 0;
        for i in 0..nums.len() {
            if count == 0 {
                candidate = nums[i];
            }
            if nums[i] == candidate {
                count += 1;
            } else {
                count -= 1;
            }
        }
        candidate
    }
}