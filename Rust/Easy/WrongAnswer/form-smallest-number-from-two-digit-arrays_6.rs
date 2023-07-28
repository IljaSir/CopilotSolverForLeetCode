impl Solution {
    pub fn min_number(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut nums1 = nums1;
        nums1.append(&mut nums2.clone());
        nums1.sort();
        nums1.into_iter().rev().fold(0, |acc, x| acc * 10 + x)
    }
}