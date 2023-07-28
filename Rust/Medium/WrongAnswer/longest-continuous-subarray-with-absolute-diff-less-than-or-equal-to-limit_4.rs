impl Solution {
    pub fn longest_subarray(nums: Vec<i32>, limit: i32) -> i32 {
        
        let mut min = std::collections::BinaryHeap::new();
        let mut max = std::collections::BinaryHeap::new();
        let mut i = 0;
        let mut j = 0;
        let mut res = 0;
        while j < nums.len() {
            min.push(std::cmp::Reverse(nums[j]));
            max.push(nums[j]);
            while !min.is_empty() && !max.is_empty() && max.peek().unwrap() - min.peek().unwrap().0 > limit {
                if nums[i] == *max.peek().unwrap() {
                    max.pop();
                }
                if nums[i] == min.peek().unwrap().0 {
                    min.pop();
                }
                i += 1;
            }
            res = res.max(j - i + 1);
            j += 1;
        }
        res as i32
    }
}