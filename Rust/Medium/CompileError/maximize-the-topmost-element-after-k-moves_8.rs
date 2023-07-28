impl Solution {
    pub fn maximum_top(nums: Vec<i32>, k: i32) -> i32 {
        
        let (mut l, mut r) = (0, k as usize);
        let mut res = -1;
        while r < nums.len() {
            res = res.max(nums[l..=r].iter().max().unwrap());
            l += 1;
            r += 1;
        }
        res
    }
}