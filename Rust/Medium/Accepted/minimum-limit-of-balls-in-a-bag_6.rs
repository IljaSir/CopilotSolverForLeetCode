impl Solution {
    pub fn minimum_size(nums: Vec<i32>, max_operations: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut l = 1;
        let mut r = nums[nums.len() - 1];
        while l < r {
            let mid = (l + r) / 2;
            let mut count = 0;
            for &num in nums.iter() {
                count += (num - 1) / mid;
            }
            if count <= max_operations {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l
    }
}