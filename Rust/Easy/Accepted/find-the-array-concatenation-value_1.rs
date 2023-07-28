impl Solution {
    pub fn find_the_array_conc_val(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut res = 0;
        while !nums.is_empty() {
            if nums.len() == 1 {
                res += nums[0] as i64;
                nums.remove(0);
            } else {
                let mut x = nums[0];
                let mut y = nums[nums.len() - 1];
                let mut xlen = 0;
                let mut ylen = 0;
                while x > 0 {
                    x /= 10;
                    xlen += 1;
                }
                while y > 0 {
                    y /= 10;
                    ylen += 1;
                }
                res += (nums[0] as i64) * 10_i64.pow(ylen as u32) + nums[nums.len() - 1] as i64;
                nums.remove(0);
                nums.remove(nums.len() - 1);
            }
        }
        res
    }
}