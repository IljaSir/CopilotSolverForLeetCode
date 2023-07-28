impl Solution {
    pub fn find_the_array_conc_val(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut ans = 0;
        while nums.len() > 0 {
            if nums.len() == 1 {
                ans += nums[0] as i64;
                nums.remove(0);
            } else {
                let x = nums[0];
                let y = nums[nums.len() - 1];
                ans += (x * 10_i32.pow(y.to_string().len() as u32) + y) as i64;
                nums.remove(0);
                nums.remove(nums.len() - 1);
            }
        }
        ans
    }
}