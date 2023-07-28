impl Solution {
    pub fn reduction_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        nums.reverse();
        let mut res = 0;
        let mut last = nums[0];
        for i in 1..nums.len() {
            if nums[i] < last {
                res += i as i32;
                last = nums[i];
            }
        }
        res
    }
}