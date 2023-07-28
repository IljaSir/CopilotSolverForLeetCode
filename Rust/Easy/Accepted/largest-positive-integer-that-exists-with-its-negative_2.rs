impl Solution {
    pub fn find_max_k(nums: Vec<i32>) -> i32 {
        
        let mut max_k = -1;
        for i in 0..nums.len() {
            for j in i..nums.len() {
                if nums[i] == -nums[j] && nums[i].abs() > max_k {
                    max_k = nums[i].abs();
                }
            }
        }
        max_k
    }
}