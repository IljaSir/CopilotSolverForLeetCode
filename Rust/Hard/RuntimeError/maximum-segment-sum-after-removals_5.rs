impl Solution {
    pub fn maximum_segment_sum(nums: Vec<i32>, remove_queries: Vec<i32>) -> Vec<i64> {
        
        let mut res = vec![0i64; remove_queries.len()];
        let mut nums = nums;
        let mut sum = 0i64;
        let mut max = 0i64;
        let mut removed = vec![false; nums.len()];
        let mut segs = vec![];
        for i in 0..nums.len() {
            let n = nums[i] as i64;
            if n > 0 {
                sum += n;
                max = max.max(sum);
            } else {
                segs.push(sum);
                sum = 0;
            }
        }
        segs.push(sum);
        for i in (0..remove_queries.len()).rev() {
            let idx = remove_queries[i] as usize;
            if nums[idx] > 0 {
                let mut sum = 0i64;
                let mut j = idx;
                while j > 0 && nums[j - 1] > 0 {
                    sum += nums[j - 1] as i64;
                    j -= 1;
                }
                let mut k = idx;
                while k + 1 < nums.len() && nums[k + 1] > 0 {
                    sum += nums[k + 1] as i64;
                    k += 1;
                }
                let mut seg_idx = 0;
                while seg_idx < segs.len() && segs[seg_idx] != sum {
                    seg_idx += 1;
                }
                segs.remove(seg_idx);
                segs.sort();
                segs.reverse();
                res[i] = max;
            } else {
                res[i] = max;
            }
            nums[idx] = 0;
            max = segs[0];
        }
        res
    }
}