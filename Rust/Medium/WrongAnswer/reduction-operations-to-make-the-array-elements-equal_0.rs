impl Solution {
    pub fn reduction_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut res = 0;
        for i in 1..nums.len() {
            if nums[i] != nums[i - 1] {
                res += i as i32;
            }
        }
        res
    }
}