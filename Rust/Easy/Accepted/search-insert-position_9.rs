impl Solution {
    pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
        
        let mut l: i32 = 0;
        let mut r: i32 = nums.len() as i32 - 1;
        let mut mid = (l + r) / 2;
        while l <= r {
            if target < nums[mid as usize] {
                r = mid - 1;
            } else if target > nums[mid as usize] {
                l = mid + 1;
            } else {
                return mid;
            }
            mid = (l + r) / 2;
        }
        return l;
    }
}