impl Solution {
    pub fn good_triplets(nums1: Vec<i32>, nums2: Vec<i32>) -> i64 {
        
        let mut res = 0;
        let n = nums1.len();
        for i in 0..n {
            for j in i+1..n {
                for k in j+1..n {
                    if nums1[i] < nums1[j] && nums1[j] < nums1[k] && nums2[i] < nums2[j] && nums2[j] < nums2[k] {
                        res += 1;
                    }
                }
            }
        }
        res
    }
}