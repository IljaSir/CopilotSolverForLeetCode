impl Solution {
    pub fn longest_subarray(nums: Vec<i32>, limit: i32) -> i32 {
        
        let mut min = std::collections::BinaryHeap::new();
        let mut max = std::collections::BinaryHeap::new();
        let mut l = 0;
        let mut r = 0;
        let mut ans = 0;
        while r < nums.len() {
            min.push(std::cmp::Reverse(nums[r]));
            max.push(nums[r]);
            while max.peek().unwrap() - min.peek().unwrap().0 > limit {
                min.retain(|&x| x.0 != nums[l]);
                max.retain(|&x| x != nums[l]);
                l += 1;
            }
            ans = ans.max(r - l + 1);
            r += 1;
        }
        ans as i32
    }
}