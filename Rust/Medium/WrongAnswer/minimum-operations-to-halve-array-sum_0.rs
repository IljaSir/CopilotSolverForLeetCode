impl Solution {
    pub fn halve_array(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut sum = nums.iter().sum::<i32>();
        let mut count = 0;
        for i in (0..nums.len()).rev() {
            sum -= nums[i];
            count += 1;
            if sum * 2 < nums[i] {
                break;
            }
        }
        count
    }
}