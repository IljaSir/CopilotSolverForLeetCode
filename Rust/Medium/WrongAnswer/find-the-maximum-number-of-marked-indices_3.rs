impl Solution {
    pub fn max_num_of_marked_indices(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = 0;
        let mut i = 0;
        let mut j = nums.len() - 1;
        while i < j {
            if 2 * nums[i] <= nums[j] {
                ans += 2;
                i += 1;
                j -= 1;
            } else {
                j -= 1;
            }
        }
        if i == j {
            ans += 1;
        }
        ans
    }
}