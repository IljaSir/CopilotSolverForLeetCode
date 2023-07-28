impl Solution {
    pub fn maximum_product(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        let k = k as usize;
        nums.sort();
        let mut ans = 1;
        let mut i = 0;
        let mut j = nums.len() - 1;
        while i < k {
            ans = ans * nums[i] as i64 % 1000000007;
            i += 1;
        }
        while j >= nums.len() - k {
            ans = ans * nums[j] as i64 % 1000000007;
            j -= 1;
        }
        ans as i32
    }
}