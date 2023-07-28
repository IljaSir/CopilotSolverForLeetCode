impl Solution {
    pub fn maximum_product(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len() as i32;
        let k = k as usize;
        let mut res = 1;
        for i in 0..k {
            res *= nums[i];
        }
        for i in 0..k {
            res *= nums[n as usize - 1 - i];
        }
        res as i32
    }
}