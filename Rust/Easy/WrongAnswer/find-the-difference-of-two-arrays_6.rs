impl Solution {
    pub fn find_difference(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut a = nums1.clone();
        let mut b = nums2.clone();
        a.sort();
        b.sort();
        let mut i = 0;
        let mut j = 0;
        let mut res = vec![vec![],vec![]];
        while i < a.len() && j < b.len() {
            if a[i] < b[j] {
                res[0].push(a[i]);
                i += 1;
            } else if a[i] > b[j] {
                res[1].push(b[j]);
                j += 1;
            } else {
                i += 1;
                j += 1;
            }
        }
        while i < a.len() {
            res[0].push(a[i]);
            i += 1;
        }
        while j < b.len() {
            res[1].push(b[j]);
            j += 1;
        }
        res
    }
}