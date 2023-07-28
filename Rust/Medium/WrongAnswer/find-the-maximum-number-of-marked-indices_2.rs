impl Solution {
    pub fn max_num_of_marked_indices(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        let mut j = nums.len() - 1;
        let mut count = 0;
        while i < j {
            if nums[i] * 2 <= nums[j] {
                count += 1;
                i += 1;
                j -= 1;
            } else {
                j -= 1;
            }
        }
        count
    }
}