impl Solution {
    pub fn number_of_pairs(nums1: Vec<i32>, nums2: Vec<i32>, diff: i32) -> i64 {
        
        let mut ans = 0i64;
        let mut nums = vec![0i64; 20001];
        for i in 0..nums1.len() {
            ans += nums[(nums1[i] - nums2[i] + diff + 10000) as usize];
            nums[(nums1[i] - nums2[i] + 10000) as usize] += 1;
        }
        ans
    }
}