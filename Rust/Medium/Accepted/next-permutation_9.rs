impl Solution {
    pub fn next_permutation(nums: &mut Vec<i32>) {
        

        let len = nums.len();
        if len < 2 { return; }
        let mut i = len - 2;
        while i > 0 && nums[i] >= nums[i + 1] { i -= 1; }
        if nums[i] >= nums[i + 1] {
            nums.reverse();
        } else {
            let mut j = len - 1;
            while nums[j] <= nums[i] { j -= 1; }
            nums.swap(i, j);
            nums[(i + 1)..].reverse();
        }
    }
}