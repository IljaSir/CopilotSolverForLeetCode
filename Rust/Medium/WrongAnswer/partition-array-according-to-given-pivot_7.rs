impl Solution {
    pub fn pivot_array(nums: Vec<i32>, pivot: i32) -> Vec<i32> {
        
        let mut nums = nums;
        let mut i = 0;
        let mut j = 0;
        let mut k = nums.len() - 1;
        while j <= k {
            if nums[j] < pivot {
                nums.swap(i, j);
                i += 1;
                j += 1;
            } else if nums[j] > pivot {
                nums.swap(j, k);
                k -= 1;
            } else {
                j += 1;
            }
        }
        nums
    }
}