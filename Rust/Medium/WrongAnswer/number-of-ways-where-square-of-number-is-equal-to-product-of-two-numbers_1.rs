impl Solution {
    pub fn num_triplets(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        nums1.sort();
        nums2.sort();
        for i in 0..nums1.len() {
            for j in 0..nums2.len()-1 {
                for k in j+1..nums2.len() {
                    if nums1[i]*nums1[i] == nums2[j]*nums2[k] {
                        res += 1;
                    }
                }
            }
        }
        for i in 0..nums2.len() {
            for j in 0..nums1.len()-1 {
                for k in j+1..nums1.len() {
                    if nums2[i]*nums2[i] == nums1[j]*nums1[k] {
                        res += 1;
                    }
                }
            }
        }
        res
    }
}