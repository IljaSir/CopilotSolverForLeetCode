impl Solution {
    pub fn max_sliding_window(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut max = Vec::new();
        let mut queue = Vec::new();
        let k = k as usize;
        for i in 0..nums.len() {
            while !queue.is_empty() && nums[queue[queue.len() - 1]] < nums[i] {
                queue.pop();
            }
            queue.push(i);
            if queue[0] == i - k {
                queue.remove(0);
            }
            if i >= k - 1 {
                max.push(nums[queue[0]]);
            }
        }
        max
    }
}