impl Solution {
    pub fn halve_array(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut sum = nums.iter().sum::<i32>();
        let mut count = 0;
        for i in (0..nums.len()).rev() {
            count += 1;
            sum -= nums[i];
            if sum * 2 < nums[i] {
                return count;
            }
        }
        count
    }
}