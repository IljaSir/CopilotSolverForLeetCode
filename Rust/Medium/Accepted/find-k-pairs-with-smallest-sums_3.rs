impl Solution {
    pub fn k_smallest_pairs(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> Vec<Vec<i32>> {
        

        let mut heap = std::collections::BinaryHeap::new();
        let mut res = vec![];
        let (n1, n2) = (nums1.len(), nums2.len());
        if n1 == 0 || n2 == 0 {
            return res;
        }
        for i in 0..n1 {
            heap.push(std::cmp::Reverse((nums1[i] + nums2[0], i, 0)));
        }
        while res.len() < k as usize && !heap.is_empty() {
            let (s, i, j) = heap.pop().unwrap().0;
            res.push(vec![nums1[i], nums2[j]]);
            if j + 1 < n2 {
                heap.push(std::cmp::Reverse((nums1[i] + nums2[j + 1], i, j + 1)));
            }
        }
        res
    }
}