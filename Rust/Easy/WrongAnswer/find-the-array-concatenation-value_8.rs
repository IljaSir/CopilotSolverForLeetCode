impl Solution {
    pub fn find_the_array_conc_val(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut ans = 0;
        while nums.len() > 0 {
            let first = nums[0];
            let last = nums[nums.len() - 1];
            let mut first_len = first.to_string().len() as i32;
            let mut last_len = last.to_string().len() as i32;
            let mut first_val = first;
            let mut last_val = last;
            while first_len > 0 {
                first_val *= 10;
                first_len -= 1;
            }
            ans += (first_val + last_val) as i64;
            nums.remove(0);
            if nums.len() > 0 {
                nums.remove(nums.len() - 1);
            }
        }
        ans
    }
}