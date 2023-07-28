impl Solution {
    pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut result = Vec::new();
        for i in nums1 {
            let mut index = 0;
            for j in 0..nums2.len() {
                if nums2[j] == i {
                    index = j;
                }
            }
            let mut flag = false;
            for j in index..nums2.len() {
                if nums2[j] > i {
                    result.push(nums2[j]);
                    flag = true;
                    break;
                }
            }
            if !flag {
                result.push(-1);
            }
        }
        result
    }
}