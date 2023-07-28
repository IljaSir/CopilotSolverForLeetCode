impl Solution {
    pub fn single_number(nums: Vec<i32>) -> i32 {
        

        let mut result = 0;
        for i in 0..32 {
            let mut sum = 0;
            for j in 0..nums.len() {
                sum += (nums[j] >> i) & 1;
            }
            result |= (sum % 3) << i;
        }
        result
    }
}