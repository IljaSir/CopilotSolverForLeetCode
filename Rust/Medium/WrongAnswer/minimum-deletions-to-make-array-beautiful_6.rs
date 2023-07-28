impl Solution {
    pub fn min_deletion(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut prev = nums[0];
        for i in 1..nums.len() {
            if prev == nums[i] {
                res += 1;
            } else {
                prev = nums[i];
            }
        }
        res
    }
}