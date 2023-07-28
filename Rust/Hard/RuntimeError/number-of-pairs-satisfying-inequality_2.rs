impl Solution {
    pub fn number_of_pairs(nums1: Vec<i32>, nums2: Vec<i32>, diff: i32) -> i64 {
        
        let mut ans = 0;
        let n = nums1.len();
        let mut v = vec![0; n];
        for i in 0..n {
            v[i] = nums1[i] - nums2[i];
        }
        v.sort();
        for i in 0..n {
            let t = nums2[i] + diff;
            let mut l = i + 1;
            let mut r = n - 1;
            while l < r {
                let mid = (l + r) / 2;
                if v[mid] <= t {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if v[l] <= t {
                ans += l as i64 - i as i64;
            } else {
                ans += l as i64 - i as i64 - 1;
            }
        }
        ans
    }
}