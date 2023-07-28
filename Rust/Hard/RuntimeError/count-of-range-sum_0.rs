impl Solution {
    pub fn count_range_sum(nums: Vec<i32>, lower: i32, upper: i32) -> i32 {
        
        let mut pre = vec![0];
        let mut ans = 0;
        for num in nums {
            let n = pre.len();
            let sum = pre[n - 1] + num;
            pre.push(sum);
            let mut l = 0;
            let mut r = n - 1;
            while l <= r {
                let mid = l + (r - l) / 2;
                if pre[mid] < sum - upper {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            let mut r = l;
            while r < n && pre[r] <= sum - lower {
                r += 1;
            }
            ans += (r - l) as i32;
        }
        ans
    }
}