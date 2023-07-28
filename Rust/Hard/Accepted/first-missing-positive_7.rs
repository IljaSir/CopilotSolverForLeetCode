impl Solution {
    pub fn first_missing_positive(nums: Vec<i32>) -> i32 {
        
        let mut i = 0;
        let mut nums = nums;
        let n = nums.len();
        while i < n {
            let mut j = nums[i] as usize;
            if j > 0 && j <= n && nums[i] != nums[j - 1] {
                nums.swap(i, j - 1);
            } else {
                i += 1;
            }
        }
        for i in 0..n {
            if i as i32 + 1 != nums[i] {
                return i as i32 + 1;
            }
        }
        n as i32 + 1
    }
}