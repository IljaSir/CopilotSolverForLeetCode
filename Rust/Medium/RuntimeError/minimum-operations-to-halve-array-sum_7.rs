impl Solution {
    pub fn halve_array(nums: Vec<i32>) -> i32 {
        
        let mut sum = nums.iter().fold(0, |acc, x| acc + x);
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while sum >= sum/2 {
            sum -= nums[i];
            i += 1;
        }
        i as i32
    }
}