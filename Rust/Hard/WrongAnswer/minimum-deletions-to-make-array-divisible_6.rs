impl Solution {
    pub fn min_operations(nums: Vec<i32>, nums_divide: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut res = 0;
        let mut cur = nums[0];
        for num in nums_divide {
            if num % cur != 0 {
                res += 1;
                cur = num;
            }
        }
        res
    }
}