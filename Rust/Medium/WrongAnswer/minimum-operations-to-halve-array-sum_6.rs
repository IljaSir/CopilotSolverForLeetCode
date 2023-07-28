impl Solution {
    pub fn halve_array(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut sum = nums.iter().sum::<i32>();
        let mut i = 0;
        let mut res = 0;
        while sum > 0 {
            sum -= nums[i];
            i += 1;
            res += 1;
        }
        res
    }
}