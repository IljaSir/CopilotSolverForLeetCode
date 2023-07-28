impl Solution {
    pub fn num_triplets(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for i in 0..nums1.len() {
            for j in i+1..nums1.len() {
                let x = nums1[i] * nums1[j];
                let y = nums1[i] * nums1[i];
                let z = nums1[j] * nums1[j];
                res += nums2.iter().filter(|&&a| a*a == x).count() as i32;
                res += nums2.iter().filter(|&&a| a*a == y).count() as i32;
                res += nums2.iter().filter(|&&a| a*a == z).count() as i32;
            }
        }
        for i in 0..nums2.len() {
            for j in i+1..nums2.len() {
                let x = nums2[i] * nums2[j];
                let y = nums2[i] * nums2[i];
                let z = nums2[j] * nums2[j];
                res += nums1.iter().filter(|&&a| a*a == x).count() as i32;
                res += nums1.iter().filter(|&&a| a*a == y).count() as i32;
                res += nums1.iter().filter(|&&a| a*a == z).count() as i32;
            }
        }
        res
    }
}