impl Solution {
    pub fn maximum_product(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort_unstable();
        let n = nums.len();
        let mut result = 1;
        let mut i = 0;
        let mut j = n - 1;
        let mut k = k as usize;
        while k > 0 {
            if k == 1 {
                result *= nums[j];
                break;
            }
            if k == 2 {
                result *= nums[j] * nums[j - 1];
                break;
            }
            if nums[i] * nums[i + 1] > nums[j] * nums[j - 1] {
                result *= nums[i] * nums[i + 1];
                i += 2;
            } else {
                result *= nums[j] * nums[j - 1];
                j -= 2;
            }
            k -= 2;
        }
        (result % 1_000_000_007) as i32
    }
}