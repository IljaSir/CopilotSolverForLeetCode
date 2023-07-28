impl Solution {
    pub fn good_triplets(nums1: Vec<i32>, nums2: Vec<i32>) -> i64 {
        
        let mut good_triplets = 0;
        for i in 0..nums1.len() {
            for j in i+1..nums1.len() {
                for k in j+1..nums1.len() {
                    if nums1[i] < nums1[j] && nums1[j] < nums1[k] {
                        if nums2[i] < nums2[j] && nums2[j] < nums2[k] {
                            good_triplets += 1;
                        }
                    }
                }
            }
        }
        good_triplets as i64
    }
}