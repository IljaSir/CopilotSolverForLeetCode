impl Solution {
    pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut result = vec![-1; nums1.len()];
        for (i, n) in nums1.iter().enumerate() {
            let mut found = false;
            for n2 in nums2.iter() {
                if found && n2 > n {
                    result[i] = *n2;
                    break;
                }
                if n2 == n {
                    found = true;
                }
            }
        }
        result
    }
}