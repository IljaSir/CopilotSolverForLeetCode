impl Solution {
    pub fn maximum_subarray_sum(nums: Vec<i32>, k: i32) -> i64 {
        
        let k = k as usize;
        let mut heap = std::collections::BinaryHeap::new();
        let mut sum = 0;
        for i in 0..k {
            heap.push(nums[i]);
            sum += nums[i] as i64;
        }
        let mut ans = sum;
        for i in k..nums.len() {
            let min = heap.peek().unwrap();
            if nums[i] > *min {
                heap.pop();
                heap.push(nums[i]);
                sum += nums[i] as i64 - *min as i64;
                ans = ans.max(sum);
            }
        }
        ans
    }
}