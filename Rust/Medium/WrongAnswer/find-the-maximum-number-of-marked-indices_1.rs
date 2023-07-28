impl Solution {
    pub fn max_num_of_marked_indices(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = 0;
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() && nums[j] <= 2 * nums[i] {
                j += 1;
            }
            ans = ans.max(j - i);
            i += 1;
        }
        ans as i32
    }
}