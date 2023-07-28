impl Solution {
    pub fn minimum_deletions(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        let mut j = nums.len() - 1;
        let mut count = 0;
        while i < j {
            if nums[i] == nums[j] {
                count += 1;
                i += 1;
                j -= 1;
            } else if nums[i] < nums[j] {
                i += 1;
            } else {
                j -= 1;
            }
        }
        count
    }
}