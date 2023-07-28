impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        
        let mut lo = 0;
        let mut hi = nums.len() as i32 - 1;
        while lo <= hi {
            let mid = lo + (hi - lo) / 2;
            if nums[mid as usize] == target {
                return mid;
            } else if nums[mid as usize] < target {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        -1
    }
}