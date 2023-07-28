impl Solution {
    pub fn min_deletion(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut last = nums[0];
        for i in 1..nums.len() {
            if nums[i] == last {
                res += 1;
            } else {
                last = nums[i];
            }
        }
        res
    }
}