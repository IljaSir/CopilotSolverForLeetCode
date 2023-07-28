impl Solution {
    pub fn two_out_of_three(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>) -> Vec<i32> {
        
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        let mut nums3 = nums3;
        nums1.sort();
        nums1.dedup();
        nums2.sort();
        nums2.dedup();
        nums3.sort();
        nums3.dedup();
        let mut res = vec![];
        for i in 0..nums1.len() {
            if nums2.contains(&nums1[i]) || nums3.contains(&nums1[i]) {
                res.push(nums1[i]);
            }
        }
        for i in 0..nums2.len() {
            if nums1.contains(&nums2[i]) || nums3.contains(&nums2[i]) {
                res.push(nums2[i]);
            }
        }
        for i in 0..nums3.len() {
            if nums1.contains(&nums3[i]) || nums2.contains(&nums3[i]) {
                res.push(nums3[i]);
            }
        }
        res.sort();
        res.dedup();
        res
    }
}