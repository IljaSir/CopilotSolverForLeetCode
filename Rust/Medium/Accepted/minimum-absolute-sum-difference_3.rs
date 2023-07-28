impl Solution {
    pub fn min_absolute_sum_diff(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut nums3 = nums1.clone();
        nums3.sort();
        let mut max = 0;
        let mut sum = 0;
        for i in 0..nums1.len() {
            let diff = (nums1[i] - nums2[i]).abs();
            sum = (sum + diff) % 1000000007;
            let j = Solution::search(&nums3, nums2[i]);
            if j < nums3.len() {
                max = max.max(diff - (nums3[j] - nums2[i]).abs());
            }
            if j > 0 {
                max = max.max(diff - (nums3[j-1] - nums2[i]).abs());
            }
        }
        (sum as i64 - max as i64).rem_euclid(1000000007) as i32
    }
    fn search(nums: &Vec<i32>, target: i32) -> usize {
        let mut low = 0;
        let mut high = nums.len();
        while low < high {
            let mid = low + (high - low) / 2;
            if nums[mid] < target {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        low
    }
}