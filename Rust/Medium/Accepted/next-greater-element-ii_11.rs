impl Solution {
    pub fn next_greater_elements(nums: Vec<i32>) -> Vec<i32> {
        

        let mut s = std::collections::VecDeque::new();
        let mut v = vec![-1; nums.len()];
        for i in 0..nums.len() * 2 {
            let i = i % nums.len();
            while !s.is_empty() && nums[*s.back().unwrap()] < nums[i] {
                v[*s.back().unwrap()] = nums[i];
                s.pop_back();
            }
            s.push_back(i);
        }
        v
    }
}