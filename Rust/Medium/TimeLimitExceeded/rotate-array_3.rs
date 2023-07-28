impl Solution {
    pub fn rotate(nums: &mut Vec<i32>, k: i32) {
        

        let k = k as usize;
        let n = nums.len();
        let mut i = 0;
        while i < k {
            let tmp = nums[n - 1];
            for j in (1..n).rev() {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
            i += 1;
        }
    }
}