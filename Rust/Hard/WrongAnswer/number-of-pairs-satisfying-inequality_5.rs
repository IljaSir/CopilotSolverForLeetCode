impl Solution {
    pub fn number_of_pairs(nums1: Vec<i32>, nums2: Vec<i32>, diff: i32) -> i64 {
        
        let mut res = 0;
        let mut nums2 = nums2;
        nums2.sort();
        for num in nums1 {
            let target = num - diff;
            res += nums2.binary_search(&target).unwrap_or_else(|x| x) as i64;
        }
        res
    }
}