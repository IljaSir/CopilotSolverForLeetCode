impl Solution {
    pub fn next_permutation(nums: &mut Vec<i32>) {
        

        let n = nums.len();
        if n <= 1 {
            return;
        }
        let mut i = n - 1;
        while i > 0 && nums[i - 1] >= nums[i] {
            i -= 1;
        }
        if i == 0 {
            nums.reverse();
            return;
        }
        let mut j = i;
        while j < n && nums[j] > nums[i - 1] {
            j += 1;
        }
        nums.swap(i - 1, j - 1);
        nums[i..].reverse();
    }
}