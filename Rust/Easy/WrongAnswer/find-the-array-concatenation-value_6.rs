impl Solution {
    pub fn find_the_array_conc_val(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut ans = 0;
        while nums.len() > 0 {
            let (first, last) = (nums[0], nums[nums.len() - 1]);
            ans += (first * 10_i32.pow(nums.len() as u32) + last) as i64;
            nums.remove(0);
            if nums.len() > 0 {
                nums.remove(nums.len() - 1);
            }
        }
        ans
    }
}