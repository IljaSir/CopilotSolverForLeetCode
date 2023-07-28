impl Solution {
    pub fn find_the_array_conc_val(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut ans = 0;
        while !nums.is_empty() {
            let n = nums.len();
            if n == 1 {
                ans = ans * 10 + nums[0] as i64;
                nums.clear();
            } else {
                ans = ans * 100 + nums[0] as i64 * 10 + nums[n - 1] as i64;
                nums.remove(0);
                nums.pop();
            }
        }
        ans
    }
}