impl Solution {
    pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![];
        for i in nums1 {
            let mut j = nums2.iter().position(|&x| x == i).unwrap();
            while j < nums2.len() {
                if nums2[j] > i {
                    res.push(nums2[j]);
                    break;
                }
                j += 1;
            }
            if j == nums2.len() {
                res.push(-1);
            }
        }
        res
    }
}