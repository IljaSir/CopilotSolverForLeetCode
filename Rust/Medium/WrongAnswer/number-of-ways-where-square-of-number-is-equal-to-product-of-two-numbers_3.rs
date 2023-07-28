impl Solution {
    pub fn num_triplets(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        for i in 0..nums1.len() {
            for j in i+1..nums1.len() {
                let mut k = 0;
                while k < nums2.len() {
                    if nums1[i] * nums1[j] == nums2[k] * nums2[k] {
                        ans += 1;
                    }
                    k += 1;
                }
            }
        }
        for i in 0..nums2.len() {
            for j in i+1..nums2.len() {
                let mut k = 0;
                while k < nums1.len() {
                    if nums2[i] * nums2[j] == nums1[k] * nums1[k] {
                        ans += 1;
                    }
                    k += 1;
                }
            }
        }
        ans
    }
}