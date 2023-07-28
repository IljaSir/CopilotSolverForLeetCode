impl Solution {
    pub fn sorted_squares(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = vec![0;nums.len()];
        let mut i = 0;
        let mut j = nums.len()-1;
        let mut k = nums.len()-1;
        while i <= j {
            if nums[i].abs() > nums[j].abs() {
                result[k] = nums[i]*nums[i];
                i += 1;
            } else {
                result[k] = nums[j]*nums[j];
                j -= 1;
            }
            k -= 1;
        }
        result
    }
}