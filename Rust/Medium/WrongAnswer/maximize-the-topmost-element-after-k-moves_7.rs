impl Solution {
    pub fn maximum_top(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut heap = std::collections::BinaryHeap::new();
        let mut res = 0;
        let mut i = nums.len() - 1;
        let mut k = k;
        while k > 0 {
            if i == 0 {
                heap.push(nums[i]);
                i -= 1;
            } else {
                heap.push(nums[i]);
                let diff = nums[i] - nums[i - 1];
                let diff = diff * (nums.len() - i) as i32;
                if diff <= k {
                    k -= diff;
                    i -= 1;
                } else {
                    let cnt = k / (nums.len() - i) as i32;
                    k -= cnt * (nums.len() - i) as i32;
                    nums[i] -= cnt;
                    if k > 0 {
                        heap.push(nums[i]);
                        k -= 1;
                        i -= 1;
                    }
                }
            }
        }
        while let Some(n) = heap.pop() {
            res = res.max(n);
        }
        res
    }
}