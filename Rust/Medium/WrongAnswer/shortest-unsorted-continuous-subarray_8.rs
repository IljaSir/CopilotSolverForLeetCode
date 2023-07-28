impl Solution {
    pub fn find_unsorted_subarray(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        let mut left = nums.len();
        let mut right = 0;
        let mut stack = vec![];
        for i in 0..nums.len() {
            while let Some(&j) = stack.last() {
                if nums[j] > nums[i] {
                    left = left.min(j);
                    right = right.max(i);
                } else {
                    break;
                }
                stack.pop();
            }
            stack.push(i);
        }
        if right >= left {
            (right - left + 1) as i32
        } else {
            0
        }
    }
}