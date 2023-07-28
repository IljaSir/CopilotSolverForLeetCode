impl Solution {
    pub fn find_difference(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut v1 = nums1.clone();
        let mut v2 = nums2.clone();
        v1.sort();
        v2.sort();
        let mut res = vec![vec![],vec![]];
        for i in 0..v1.len() {
            if v2.get(i).is_some() {
                if v1[i] != v2[i] {
                    res[1].push(v2[i]);
                    res[0].push(v1[i]);
                }
            } else {
                res[0].push(v1[i]);
            }
        }
        if v2.len() > v1.len() {
            for i in v1.len()..v2.len() {
                res[1].push(v2[i]);
            }
        }
        res
    }
}