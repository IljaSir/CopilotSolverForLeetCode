impl Solution {
    pub fn sub_array_ranges(nums: Vec<i32>) -> i64 {
        
        let mut res = 0;
        let n = nums.len() as i64;
        for i in 0..n {
            res += (i + 1) * (n - i) * (nums[i as usize] as i64);
        }
        res
    }
}