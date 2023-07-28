impl Solution {
    pub fn min_number(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut s = nums1;
        s.extend(nums2);
        s.sort();
        s.iter().fold(0, |acc, &x| acc * 10 + x)
    }
}