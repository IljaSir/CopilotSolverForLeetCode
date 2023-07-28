impl Solution {
    pub fn min_number(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut nums = nums1;
        for num in nums2 {
            nums.push(num);
        }
        nums.sort();
        let mut result = 0;
        for num in nums {
            result = result * 10 + num;
        }
        result
    }
}