impl Solution {
    pub fn sub_array_ranges(nums: Vec<i32>) -> i64 {
        
        let mut res = 0;
        let n = nums.len() as i64;
        for i in 0..nums.len() {
            let l = i as i64;
            let r = n - 1 - i as i64;
            let x = nums[i] as i64;
            res += x * (l + 1) * (r + 1);
        }
        res
    }
}