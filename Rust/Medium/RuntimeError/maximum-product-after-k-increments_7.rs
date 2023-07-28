impl Solution {
    pub fn maximum_product(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = 1;
        let mut i = 0;
        let mut j = nums.len() - 1;
        let mut k = k;
        while k > 0 {
            if k % 2 == 0 {
                ans = ans * nums[i] % 1000000007;
                i += 1;
                k -= 1;
            } else {
                ans = ans * nums[j] % 1000000007;
                j -= 1;
                k -= 1;
            }
        }
        ans
    }
}