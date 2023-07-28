impl Solution {
    pub fn merge_arrays(nums1: Vec<Vec<i32>>, nums2: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        nums1.append(&mut nums2);
        nums1.sort_by(|a, b| a[0].cmp(&b[0]));
        let mut result = vec![];
        for i in 0..nums1.len() {
            if i == 0 || nums1[i][0] != nums1[i - 1][0] {
                result.push(nums1[i].clone());
            } else {
                result[result.len() - 1][1] += nums1[i][1];
            }
        }
        result
    }
}