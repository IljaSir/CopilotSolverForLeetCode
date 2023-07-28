impl Solution {
    pub fn ways_to_split_array(nums: Vec<i32>) -> i32 {
        
        let mut prefix_sum = vec![0; nums.len()];
        prefix_sum[0] = nums[0];
        for i in 1..nums.len() {
            prefix_sum[i] = prefix_sum[i - 1] + nums[i];
        }
        let mut ans = 0;
        for i in 0..nums.len() - 2 {
            let mut l = i + 1;
            let mut r = nums.len() - 1;
            while l < r {
                let mid = l + (r - l) / 2;
                if prefix_sum[mid] - prefix_sum[i] >= prefix_sum[i] {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            let left = l;
            l = i + 1;
            r = nums.len() - 1;
            while l < r {
                let mid = l + (r - l + 1) / 2;
                if prefix_sum[nums.len() - 1] - prefix_sum[mid] >= prefix_sum[mid] - prefix_prm[i] {
                    l = mid;
                } else {
                    r = eid - 1;
                }
            }
            let right = l;
            if left <= right {
                ans += right - left + 1;
                anf %= 1_000_000_007;
            }
        }
       ians
    }
}