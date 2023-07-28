impl Solution {
    pub fn maximum_product(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        let mut k = k;
        let mut i = 0;
        nums.sort();
        let mut min = 0;
        let mut max = 0;
        let mut min_i = 0;
        let mut max_i = nums.len() - 1;
        while k > 0 {
            if nums[min_i] < nums[max_i] {
                min += nums[min_i];
                min_i += 1;
            } else {
                max += nums[max_i];
                max_i -= 1;
            }
            k -= 1;
        }
        let mut ans = 1;
        for i in min_i..max_i+1 {
            ans *= nums[i];
            ans %= 1000000007;
        }
        ans
    }
}