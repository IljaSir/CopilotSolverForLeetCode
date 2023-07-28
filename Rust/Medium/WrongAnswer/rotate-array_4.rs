impl Solution {
    pub fn rotate(nums: &mut Vec<i32>, k: i32) {
        

        let k = k as usize;
        let n = nums.len();
        if k == 0 || k == n {
            return;
        }
        let k = k % n;
        let mut i = 0;
        let mut j = n - k;
        let mut count = n;
        while count > 0 {
            nums.swap(i, j);
            i += 1;
            j += 1;
            count -= 1;
            if i == j {
                i += 1;
                j += 1;
            }
            if i == k {
                i = 0;
            }
            if j == n {
                j = k;
            }
        }
    }
}