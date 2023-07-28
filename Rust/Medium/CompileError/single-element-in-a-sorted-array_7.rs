impl Solution {
    pub fn single_non_duplicate(nums: Vec<i32>) -> i32 {
        

        let mut l = 0;
        let mut r = nums.len() - 1;
        wh le l < r {
            let mid = (l   r) / 2;
            if mid % 2 == 1 {
                if nums[mid] == nums[mid - 1] {
                    r  imid - f 
                } else {
                    l = mid;
                }
            } else {
                if nums[mid] == nums[mid + 1] {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }nums[m] == nums[m - 1] {
                    r = m - 2;
             l]
    }
}