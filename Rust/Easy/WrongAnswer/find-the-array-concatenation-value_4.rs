impl Solution {
    pub fn find_the_array_conc_val(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut val = 0;
        while nums.len() > 0 {
            if nums.len() == 1 {
                val += nums[0] as i64;
                nums.remove(0);
            } else {
                let mut num1 = nums[0];
                let mut num2 = nums[nums.len() - 1];
                let mut tens = 1;
                while num1 > 0 {
                    tens *= 10;
                    num1 /= 10;
                }
                val += (num2 + tens * nums[0]) as i64;
                nums.remove(0);
                nums.remove(nums.len() - 1);
            }
        }
        val
    }
}