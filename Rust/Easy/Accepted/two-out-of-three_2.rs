impl Solution {
    pub fn two_out_of_three(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>) -> Vec<i32> {
        
        let mut result: Vec<i32> = Vec::new();
        let mut v1: Vec<i32> = Vec::new();
        let mut v2: Vec<i32> = Vec::new();
        let mut v3: Vec<i32> = Vec::new();
        for i in nums1.iter() {
            if !v1.contains(i) {
                v1.push(*i);
            }
        }
        for i in nums2.iter() {
            if !v2.contains(i) {
                v2.push(*i);
            }
        }
        for i in nums3.iter() {
            if !v3.contains(i) {
                v3.push(*i);
            }
        }
        for i in v1.iter() {
            if v2.contains(i) || v3.contains(i) {
                if !result.contains(i) {
                    result.push(*i);
                }
            }
        }
        for i in v2.iter() {
            if v1.contains(i) || v3.contains(i) {
                if !result.contains(i) {
                    result.push(*i);
                }
            }
        }
        for i in v3.iter() {
            if v1.contains(i) || v2.contains(i) {
                if !result.contains(i) {
                    result.push(*i);
                }
            }
        }
        result
    }
}