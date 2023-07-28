impl Solution {
    pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut ans = vec![-1; nums1.len()];
        let mut stack = vec![];
        let mut map = std::collections::HashMap::new();
        for i in 0..nums2.len() {
            while !stack.is_empty() && nums2[*stack.last().unwrap()] < nums2[i] {
                map.insert(stack.pop().unwrap(), nums2[i]);
            }
            stack.push(i);
        }
        for i in 0..nums1.len() {
            if let Some(&v) = map.get(&nums2.iter().position(|&x| x == nums1[i]).unwrap()) {
                ans[i] = v;
            }
        }
        ans
    }
}