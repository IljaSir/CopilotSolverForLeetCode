impl Solution {
    pub fn two_out_of_three(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>) -> Vec<i32> {
        
        let mut v: Vec<i32> = Vec::new();
        let mut m: Vec<i32> = Vec::new();
        for i in 0..nums1.len() {
            if !m.contains(&nums1[i]) {
                m.push(nums1[i]);
            }
        }
        for i in 0..nums2.len() {
            if !m.contains(&nums2[i]) {
                m.push(nums2[i]);
            }
        }
        for i in 0..nums3.len() {
            if !m.contains(&nums3[i]) {
                m.push(nums3[i]);
            }
        }
        for i in 0..m.len() {
            if nums1.contains(&m[i]) && nums2.contains(&m[i]) {
                v.push(m[i]);
            } else if nums1.contains(&m[i]) && nums3.contains(&m[i]) {
                v.push(m[i]);
            } else if nums2.contains(&m[i]) && nums3.contains(&m[i]) {
                v.push(m[i]);
            }
        }
        v
    }
}