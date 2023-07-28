impl Solution {
    pub fn find_the_array_conc_val(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut res = 0;
        while nums.len() > 0 {
            let left = nums.remove(0);
            let right = nums.pop().unwrap_or(left);
            res += (left * 10i32.pow(right.to_string().len() as u32) + right) as i64;
        }
        res
    }
}