impl Solution {
    pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![-1; nums1.len()];
        for i in 0..nums1.len() {
            let mut flag = false;
            for j in 0..nums2.len() {
                if flag && nums2[j] > nums1[i] {
                    res[i] = nums2[j];
                    break;
                }
                if nums2[j] == nums1[i] {
                    flag = true;
                }
            }
        }
        res
    }
}