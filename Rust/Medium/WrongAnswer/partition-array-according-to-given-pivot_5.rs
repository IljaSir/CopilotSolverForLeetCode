impl Solution {
    pub fn pivot_array(nums: Vec<i32>, pivot: i32) -> Vec<i32> {
        
        let mut nums = nums;
        let mut l = 0;
        let mut r = nums.len() - 1;
        let mut i = 0;
        while i <= r {
            if nums[i] < pivot {
                nums.swap(i, l);
                l += 1;
                i += 1;
            } else if nums[i] > pivot {
                nums.swap(i, r);
                r -= 1;
            } else {
                i += 1;
            }
        }
        nums
    }
}