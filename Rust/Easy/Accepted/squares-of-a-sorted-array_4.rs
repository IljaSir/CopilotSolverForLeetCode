impl Solution {
    pub fn sorted_squares(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = vec![0; nums.len()];
        let mut l = 0;
        let mut r = nums.len() - 1;
        for i in (0..nums.len()).rev() {
            let left = nums[l].abs();
            let right = nums[r].abs();
            if left > right {
                result[i] = left * left;
                l += 1;
            } else {
                result[i] = right * right;
                r -= 1;
            }
        }
        result
    }
}