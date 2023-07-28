impl Solution {
    pub fn minimum_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut res = 0;
        let mut cur = 0;
        for i in 0..nums.len() {
            if nums[i] > cur {
                res += nums[i] - cur;
                cur = nums[i];
            }
        }
        res
    }
}