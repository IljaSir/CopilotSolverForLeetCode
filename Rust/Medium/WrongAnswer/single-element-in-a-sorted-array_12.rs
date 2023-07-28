impl Solution {
    pub fn single_non_duplicate(nums: Vec<i32>) -> i32 {
        

        let mut l = 0;
        let mut r = nums.len() - 1;
        while l < r {
            let mid = (l + r) / 2;
            if mid % 2 == 1 {
                if nums[mid] == nums[mid - 1] {
                    r = mid - 2;
                } else {
                    l = mid + 1;
                }
            } else {
                if nums[mid] == nums[mid + 1] {
                    r = mid - 1;
                } else {
                    l = mid + 2;
                }
            }
        }
        nums[l]
    }
}