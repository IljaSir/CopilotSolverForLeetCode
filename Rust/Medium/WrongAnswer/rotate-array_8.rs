impl Solution {
    pub fn rotate(nums: &mut Vec<i32>, k: i32) {
        

        let mut k = k as usize;
        let mut i = 0;
        let mut j = nums.len() - 1;
        while k > 0 {
            let t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
            i += 1;
            j -= 1;
            k -= 1;
        }
    }
}