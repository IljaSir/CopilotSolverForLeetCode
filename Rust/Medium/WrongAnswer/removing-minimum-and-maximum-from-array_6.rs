impl Solution {
    pub fn minimum_deletions(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut min = nums[0];
        let mut max = nums[nums.len()-1];
        let mut count = 0;
        for i in 0..nums.len(){
            if nums[i] == min || nums[i] == max{
                count += 1;
            }
        }
        count
    }
}