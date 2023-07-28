impl Solution {
    pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut result = Vec::new();
        for i in 0..nums1.len() {
            let mut find = false;
            for j in 0..nums2.len() {
                if find {
                    if nums1[i] < nums2[j] {
                        result.push(nums2[j]);
                        break;
                    }
                } else {
                    if nums1[i] == nums2[j] {
                        find = true;
                    }
                }
            }
            if !find || result.len() < i+1 {
                result.push(-1);
            }
        }
        result
    }
}