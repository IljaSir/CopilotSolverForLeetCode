impl Solution {
    pub fn min_number(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        nums1.sort();
        nums2.sort();
        let mut i = 0;
        let mut j = 0;
        let mut ans = vec![];
        while i < nums1.len() && j < nums2.len() {
            if nums1[i] < nums2[j] {
                ans.push(nums1[i]);
                i += 1;
            } else {
                ans.push(nums2[j]);
                j += 1;
            }
        }
        if i < nums1.len() {
            ans.extend_from_slice(&nums1[i..]);
        }
        if j < nums2.len() {
            ans.extend_from_slice(&nums2[j..]);
        }
        ans.iter().fold(0, |acc, &x| acc * 10 + x)
    }
}