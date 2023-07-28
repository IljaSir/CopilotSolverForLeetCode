impl Solution {
    pub fn max_sum(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut i = 0;
        let mut j = 0;
        let mut sum1 = 0;
        let mut sum2 = 0;
        let mut sum = 0;
        let mut max = 0;
        loop {
            if i >= nums1.len() && j >= nums2.len() {
                break;
            }
            if i >= nums1.len() {
                sum += nums2[j];
                j += 1;
                continue;
            }
            if j >= nums2.len() {
                sum += nums1[i];
                i += 1;
                continue;
            }
            if nums1[i] < nums2[j] {
                sum1 += nums1[i];
                i += 1;
            } else if nums1[i] > nums2[j] {
                sum2 += nums2[j];
                j += 1;
            } else {
                sum += nums1[i];
                sum += std::cmp::max(sum1, sum2);
                max = std::cmp::max(max, sum);
                sum1 = 0;
                sum2 = 0;
                sum = 0;
                i += 1;
                j += 1;
            }
        }
        max = std::cmp::max(max, sum);
        max += std::cmp::max(sum1, sum2);
        max % (1e9 as i32 + 7)
    }
}