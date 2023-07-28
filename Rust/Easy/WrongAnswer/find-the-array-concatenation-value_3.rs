impl Solution {
    pub fn find_the_array_conc_val(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut ans = 0;
        loop {
            if nums.len() == 0 {
                break;
            }
            if nums.len() == 1 {
                ans += nums[0] as i64;
                break;
            }
            let mut a = nums[0];
            let mut b = nums[nums.len() - 1];
            let mut c = 0;
            while a > 0 {
                c += 1;
                a /= 10;
            }
            ans += (b + nums[0] * i32::pow(10, c)) as i64;
            nums.remove(0);
            nums.pop();
        }
        ans
    }
}