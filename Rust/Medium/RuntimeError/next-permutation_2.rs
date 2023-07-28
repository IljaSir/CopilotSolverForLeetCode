impl Solution {
    pub fn next_permutation(nums: &mut Vec<i32>) {
        

        let mut i = nums.len() - 2;
        while i >= 0 && nums[i] >= nums[i + 1] {
            i -= 1;
        }
        if i >= 0 {
            let mut j = nums.len() - 1;
            while j >= 0 && nums[j] <= nums[i] {
                j -= 1;
            }
            nums.swap(i, j);
        }
        nums[i + 1..].reverse();
    }
}