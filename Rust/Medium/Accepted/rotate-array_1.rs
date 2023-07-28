impl Solution {
    pub fn rotate(nums: &mut Vec<i32>, k: i32) {
        

        let mut k = k as usize;
        let len = nums.len();
        k %= len;
        nums.reverse();
        nums[..k].reverse();
        nums[k..].reverse();
    }
}