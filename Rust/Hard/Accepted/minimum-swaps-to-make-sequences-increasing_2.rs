impl Solution {
    pub fn min_swap(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let n = nums1.len();
        let mut swap = vec![n as i32; n];
        let mut no_swap = vec![n as i32; n];
        no_swap[0] = 0;
        swap[0] = 1;
        for i in 1..n {
            if nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1] {
                no_swap[i] = no_swap[i-1];
                swap[i] = swap[i-1] + 1;
            }
            if nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1] {
                no_swap[i] = no_swap[i].min(swap[i-1]);
                swap[i] = swap[i].min(no_swap[i-1] + 1);
            }
        }
        no_swap[n-1].min(swap[n-1])
    }
}