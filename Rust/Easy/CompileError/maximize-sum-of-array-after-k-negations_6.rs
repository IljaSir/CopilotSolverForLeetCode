impl Solution {
    pub fn largest_sum_after_k_negations(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        let mut k = k;
        nums.sort_unstable();
        let mut i = 0;
        while i < nums.len() && k > 0 && nums[i] < 0 {
            nums[i] = -nums[i];
            i += 1;
            k -= 1;
        }
        let mut sum = 0;
        for n in nums {
            sum += n;
        }
        if k > 0 && k % 2 != 0 {
            sum -= 2 * nums[0];
        }
        sum
    }
}