impl Solution {
    pub fn min_number(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut nums = nums1;
        nums.extend(nums2);
        nums.sort();
        nums.iter().fold(0, |acc, x| acc * 10 + x)
    }
}