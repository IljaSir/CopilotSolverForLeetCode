impl Solution {
    pub fn k_smallest_pairs(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut heap = std::collections::BinaryHeap::new();
        let mut index = vec![0; nums1.len()];
        for i in 0..nums1.len() {
            heap.push((-(nums1[i] + nums2[0]), i));
        }
        for _ in 0..k.min(nums1.len() as i32 * nums2.len() as i32) {
            let (sum, i) = heap.pop().unwrap();
            let j = index[i];
            res.push(vec![nums1[i], nums2[j]]);
            if j + 1 < nums2.len() {
                heap.push((-(nums1[i] + nums2[j + 1]), i));
                index[i] += 1;
            }
        }
        res
    }
}