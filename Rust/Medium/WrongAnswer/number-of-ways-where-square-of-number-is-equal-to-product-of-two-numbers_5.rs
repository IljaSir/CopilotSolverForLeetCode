impl Solution {
    pub fn num_triplets(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for i in 0..nums1.len() {
            for j in 0..nums1.len() {
                if i != j {
                    let n = nums1[i] * nums1[j];
                    let mut k = 0;
                    while k < nums2.len() {
                        if n == nums2[k] * nums2[k] {
                            res += 1;
                        }
                        k += 1;
                    }
                }
            }
        }
        for i in 0..nums2.len() {
            for j in 0..nums2.len() {
                if i != j {
                    let n = nums2[i] * nums2[j];
                    let mut k = 0;
                    while k < nums1.len() {
                        if n == nums1[k] * nums1[k] {
                            res += 1;
                        }
                        k += 1;
                    }
                }
            }
        }
        res
    }
}