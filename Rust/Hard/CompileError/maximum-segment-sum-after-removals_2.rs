impl Solution {
    pub fn maximum_segment_sum(nums: Vec<i32>, remove_queries: Vec<i32>) -> Vec<i64> {
        
        let n = nums.len();
        let mut nums = nums;
        let mut remove_queries = remove_queries;
        let mut ans = vec![0; n];
        let mut bit = vec![0; n + 1];
        let mut sum = vec![0; n + 1];
        let mut segs = vec![];
        let mut removed = vec![false; n];
        for i in 0..n {
            sum[i + 1] = sum[i] + nums[i];
        }
        for i in 0..n {
            let idx = remove_queries[i] as usize;
            removed[idx] = true;
            let mut l = 0;
            let mut r = segs.len();
            while l < r {
                let mid = (l + r) / 2;
                if segs[mid].1 < idx {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            let mut r = l;
            while r < segs.len() && segs[r].0 <= idx {
                r += 1;
            }
            let mut l = l;
            let mut left = idx;
            let mut right = idx;
            if l > 0 {
                l -= 1;
                if segs[l].1 >= idx {
                    continue;
                }
                left = segs[l].0;
            }
            if r < segs.len() {
                if segs[r].0 <= idx {
                    continue;
                }
                right = segs[r].1;
            }
            let seg = (left, right);
            segs.insert(l, seg);
            let mut idx = left as usize;
            while idx <= right as usize {
                update(&mut bit, idx, nums[idx]);
                idx += idx & idx.wrapping_neg();
            }
            let mut left = 0;
            let mut right = n;
            while left < right {
                let mid = (left + right) / 2;
                if sum[mid] < sum[idx] {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            let mut right = left;
            while right < n && sum[right + 1] <= sum[idx] {
                right += 1;
            }
            let mut left = left;
            while left > 0 && sum[left
    }
}