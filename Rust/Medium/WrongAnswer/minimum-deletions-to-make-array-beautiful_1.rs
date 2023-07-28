impl Solution {
    pub fn min_deletion(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut i = 0;
        while i < nums.len() - 1 {
            if nums[i] == nums[i + 1] {
                count += 1;
                i += 1;
            }
            i += 1;
        }
        count
    }
}