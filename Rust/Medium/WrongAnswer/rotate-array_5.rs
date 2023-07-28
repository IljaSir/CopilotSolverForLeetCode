impl Solution {
    pub fn rotate(nums: &mut Vec<i32>, k: i32) {
        

        let mut i = 0;
        let mut j = k as usize;
        while i < nums.len() {
            nums.swap(i, j);
            i += 1;
            j += 1;
            if j >= nums.len() {
                j = j % nums.len();
            }
        }
    }
}