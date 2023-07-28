impl Solution {
    pub fn max_operations(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut count = 0;
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        let mut j = nums.len() - 1;
        while i < j {
            if nums[i] + nums[j] == k {
                count += 1;
                i += 1;
                j -= 1;
            } else if nums[i] + nums[j] > k {
                j -= 1;
            } else {
                i += 1;
            }
        }
        count
    }
}