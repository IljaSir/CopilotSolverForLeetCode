impl Solution {
    pub fn rotate(nums: &mut Vec<i32>, k: i32) {
        

        let mut k = k as usize;
        let n = nums.len();
        k %= n;
        nums.reverse();
        nums[0..k].reverse();
        nums[k..n].reverse();
    }
}