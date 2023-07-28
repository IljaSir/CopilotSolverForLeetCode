impl Solution {
    pub fn halve_array(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut sum = nums.iter().sum::<i32>();
        nums.sort_unstable();

        let mut i = nums.len() - 1;
        let mut count = 0;
        while sum > 0 {
            sum -= nums[i];
            i -= 1;
            count += 1;
        }
        count
    }
}