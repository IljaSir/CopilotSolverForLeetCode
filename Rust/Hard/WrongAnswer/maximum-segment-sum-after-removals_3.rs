impl Solution {
    pub fn maximum_segment_sum(nums: Vec<i32>, remove_queries: Vec<i32>) -> Vec<i64> {
        
        let n = nums.len();
        let mut ans = vec![0; n];
        let mut nums = nums;
        let mut remove_queries = remove_queries;
        let mut remove_queries: Vec<(usize, usize)> = remove_queries.into_iter().enumerate().map(|(i, v)| (i, v as usize)).collect();
        remove_queries.sort_by(|(_, a), (_, b)| b.cmp(a));
        let mut segs = vec![];
        let mut prev = 0;
        for i in 0..n {
            if nums[i] == 0 {
                if prev < i {
                    segs.push((prev, i));
                }
                prev = i + 1;
            }
        }
        if prev < n {
            segs.push((prev, n));
        }
        for &(i, j) in &segs {
            ans[i] = nums[i..j].iter().sum::<i32>() as i64;
        }
        for &(i, j) in &remove_queries {
            nums[j] = 0;
            if let Some(&(k, l)) = segs.iter().find(|&&(k, l)| k <= j && j < l) {
                segs.retain(|&(k, l)| k != j && j != l - 1);
                if k < j {
                    segs.push((k, j));
                }
                if j + 1 < l {
                    segs.push((j + 1, l));
                }
            }
            for &(k, l) in &segs {
                ans[k] = nums[k..l].iter().sum::<i32>() as i64;
            }
        }
        ans
    }
}