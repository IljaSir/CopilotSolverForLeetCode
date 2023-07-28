impl Solution {
    pub fn min_absolute_sum_diff(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let modu = 1000000007;
        let mut nums1 = nums1;
        let mut ans = 0;
        let mut maxn = 0;
        let mut index = 0;
        for i in 0..nums1.len() {
            let mut minn = 100000;
            ans = (ans + (nums1[i] - nums2[i]).abs()) % modu;
            for j in 0..nums1.len() {
                if (nums1[j] - nums2[i]).abs() < minn {
                    minn = (nums1[j] - nums2[i]).abs();
                    index = j;
                }
            }
            if (nums1[index] - nums2[i]).abs() > maxn {
                maxn = (nums1[index] - nums2[i]).abs();
            }
        }
        (ans - maxn + modu) % modu
    }
}