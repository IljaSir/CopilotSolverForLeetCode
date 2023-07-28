impl Solution {
    pub fn left_rigth_difference(nums: Vec<i32>) -> Vec<i32> {
        
        let mut left = vec![0; nums.len()];
        let mut right = vec![0; nums.len()];
        let mut res = vec![0; nums.len()];
        for i in 1..nums.len() {
            left[i] = left[i-1] + nums[i-1];
        }
        for i in (0..nums.len()-1).rev() {
            right[i] = right[i+1] + nums[i+1];
        }
        for i in 0..nums.len() {
            res[i] = (left[i] - right[i]).abs();
        }
        res
    }
}