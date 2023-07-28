impl Solution {
    pub fn min_deletion(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for i in (0..nums.len()-1).step_by(2) {
            if nums[i] == nums[i+1] {
                res += 1;
            }
        }
        res
    }
}