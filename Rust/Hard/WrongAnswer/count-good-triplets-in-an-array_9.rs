impl Solution {
    pub fn good_triplets(nums1: Vec<i32>, nums2: Vec<i32>) -> i64 {
        
        let mut c = 0;
        for (i, n1) in nums1.iter().enumerate() {
            for (j, n2) in nums2.iter().enumerate() {
                if n1 == n2 && i < j {
                    for (k, n3) in nums2.iter().enumerate() {
                        if n1 == n3 && j < k {
                            c += 1;
                        }
                    }
                }
            }
        }
        c
    }
}