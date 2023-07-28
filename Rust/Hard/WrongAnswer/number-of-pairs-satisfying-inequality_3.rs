impl Solution {
    pub fn number_of_pairs(nums1: Vec<i32>, nums2: Vec<i32>, diff: i32) -> i64 {
        
        let mut result = 0;
        let n = nums1.len();
        let mut nums2 = nums2;
        nums2.sort();
        for i in 0..n {
            let j = nums2.binary_search(&(nums1[i] - diff)).unwrap_or_else(|x| x);
            result += j as i64;
        }
        result
    }
}