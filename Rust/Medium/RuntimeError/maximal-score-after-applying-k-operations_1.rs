impl Solution {
    pub fn max_kelements(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut nums = nums;
        nums.sort();
        let mut res = 0;
        let n = nums.len();
        for i in 0..n {
            res += nums[i] as i64;
        }
        let mut q = std::collections::BinaryHeap::new();
        for i in 0..n - 1 {
            if nums[i] == nums[i + 1] {
                continue;
            }
            q.push(nums[i + 1] - nums[i]);
        }
        for _ in 0..k {
            let t = q.pop().unwrap();
            res += t as i64;
            if t > 1 {
                q.push(t / 3);
            }
        }
        res
    }
}