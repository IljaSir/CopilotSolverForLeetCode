impl Solution {
    pub fn number_of_pairs(nums1: Vec<i32>, nums2: Vec<i32>, diff: i32) -> i64 {
        
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        nums1.sort();
        nums2.sort();
        let mut ans: i64 = 0;
        for i in 0..nums1.len() {
            ans += nums2.len() as i64 - Self::upper_bound(&nums2, nums1[i] - diff) as i64;
        }
        ans
    }
    fn upper_bound(nums: &Vec<i32>, target: i32) -> usize {
        let mut left = 0;
        let mut right = nums.len();
        while left < right {
            let mid = (left + right) / 2;
            if nums[mid] > target {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left
    }
}