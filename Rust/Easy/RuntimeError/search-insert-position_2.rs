impl Solution {
    pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
        
        let mut l = 0;
        let mut r = nums.len() - 1;
        while l <= r {
            let mid = (l + r) / 2;
            if nums[mid] == target {
                return mid as i32;
            } else if nums[mid] < target {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        l as i32
    }
}