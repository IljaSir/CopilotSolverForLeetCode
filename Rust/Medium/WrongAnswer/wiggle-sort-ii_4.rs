impl Solution {
    pub fn wiggle_sort(nums: &mut Vec<i32>) {
        

        let len = nums.len();
        let mut i = 0;
        while i < len - 1 {
            if (i % 2 == 0 && nums[i] > nums[i+1]) || (i % 2 == 1 && nums[i] < nums[i+1]) {
                nums.swap(i, i+1);
            }
            i += 1;
        }
    }
}