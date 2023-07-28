impl Solution {
    pub fn rotate(nums: &mut Vec<i32>, k: i32) {
        

        let k = k as usize;
        let n = nums.len();
        nums.rotate_right(k % n);
    }
}