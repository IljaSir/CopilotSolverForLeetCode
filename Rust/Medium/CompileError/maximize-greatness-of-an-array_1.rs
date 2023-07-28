impl Solution {
    pub fn maximize_greatness(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut max = 0;
        for i in 1..nums.len() {
            max += nums[i] > nums[i - 1] as i32;
        }
        max
    }
}