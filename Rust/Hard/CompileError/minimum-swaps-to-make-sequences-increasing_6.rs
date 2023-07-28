impl Solution {
    pub fn min_swap(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut swap = vec![1; nums1.len()];
        let mut no_swap = vec![0; nums1.len()];
        for i in 1..nums1.len() {
            if nums1[i-1] < nums1[i] && nums2[i-1] < nums2[i] {
                if nums1[i-1] < nums2[i] && nums2[i-1] < nums1[i] {
                    swap[i] = swap[i-1].min(no_swap[i-1]) + 1;
                    no_swap[i] = no_swap[i-1];
                } else {
                    swap[i] = swap[i-1] + 1;
                    no_swap[i] = no_swap[i-1];
                }
            } else {
                swap[i] = no_swap[i-1] + 1;
                no_swap[i] = swap[i-1];
            }
        }
        swap.last().unwrap().min(no_swap.last().unwrap())
    }
}