impl Solution {
    pub fn find_pairs(nums: Vec<i32>, k: i32) -> i32 {
        

        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        let mut j = 1;
        let mut count = 0;
        while j < nums.len() {
            if i == j || nums[j] - nums[i] < k {
                j += 1;
            } else if nums[j] - nums[i] > k {
                i += 1;
            } else {
                count += 1;
                i += 1;
                while i < nums.len() && nums[i] == nums[i - 1] {
                    i += 1;
                }
            }
        }
        count
    }
}