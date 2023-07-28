impl Solution {
    pub fn num_triplets(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for i in 0..nums1.len() {
            for j in i+1..nums1.len() {
                let t = nums1[i] * nums1[j];
                let mut cnt = 0;
                for k in 0..nums2.len() {
                    if nums2[k] * nums2[k] == t {
                        cnt += 1;
                    }
                }
                res += cnt;
            }
        }
        for i in 0..nums2.len() {
            for j in i+1..nums2.len() {
                let t = nums2[i] * nums2[j];
                let mut cnt = 0;
                for k in 0..nums1.len() {
                    if nums1[k] * nums1[k] == t {
                        cnt += 1;
                    }
                }
                res += cnt;
            }
        }
        res
    }
}